import { Component, inject } from '@angular/core';
import { SessionsFormComponent } from '../../components/sessions-form/sessions-form.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { SessionService } from '../../services/session.service';

@Component({
  selector: 'app-signin',
  imports: [SessionsFormComponent],
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.scss',
})
export class SigninComponent {
  signin: FormGroup;
  private readonly router = inject(Router);
  private readonly http = inject(HttpClient);
  private readonly fb = inject(FormBuilder);
  private readonly sessionService = inject(SessionService);

  constructor() {
    this.signin = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
  }

  signIn() {
    if (this.signin.valid) {
      const sessionData = this.signin.value;
      this.sessionService.authenticate(sessionData).subscribe({
        next: () => {
          this.navigateApp();
        },
        error: (error: HttpErrorResponse) => {
          console.error('Erreur ouverture session:', error);
          alert(
            "Erreur lors de l'ouverture de la session. Vérifiez vos identifiants."
          );
        },
      });
    } else {
      console.log('Formulaire invalide');
    }
  }

  navigateApp() {
    this.router.navigate(['dashboard']);
  }
}
