import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

interface Session {
  id?: number;
  firstname: string;
  lastname: string;
  password: string;
}

@Injectable({
  providedIn: 'root',
})
export class SessionService {
  private readonly apiUrl = ' http://localhost:8080/employees';
  private readonly http = inject(HttpClient);

  createSession(sessionData: Session): Observable<Session> {
    return this.http.post<Session>(this.apiUrl, sessionData);
  }

  authenticate(sessionData: Session): Observable<Session> {
    return this.http.post<Session>(`${this.apiUrl}/authenticate`, sessionData);
  }
}
