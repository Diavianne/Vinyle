import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

interface Employee {
  id?: number;
  firstname?: string;
  lastname?: string;
  email: string;
  password: string;
}

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private readonly apiUrl = 'http://localhost:8080/employees';
  private readonly http = inject(HttpClient);
  private readonly router = inject(Router);

  createSession(sessionData: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.apiUrl, sessionData);
  }

  authenticate(sessionData: { email: string; password: string }) {
    this.http
      .post(`${this.apiUrl}/authenticate`, sessionData, {
        responseType: 'text',
      })
      .subscribe({
        next: (token: string) => {
          if (token) {
            localStorage.setItem('token', token);
            this.router.navigate(['/dashboard']);
          } else {
            console.error('Token manquant dans la réponse');
          }
        },
        error: (error: HttpErrorResponse) => {
          console.error('Erreur de connexion', error);
        },
      });
  }

  isAuthenticated(): boolean {
    return !!localStorage.getItem('token');
  }

  getAuthToken(): string | null {
    return localStorage.getItem('token');
  }

  saveAuthToken(token: string) {
    localStorage.setItem('token', token);
    this.router.navigate(['/dashboard']);
  }

  logOut() {
    localStorage.removeItem('token');
    this.router.navigate(['signin']);
  }
}
