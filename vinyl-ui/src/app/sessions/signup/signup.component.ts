import { AuthService } from '../auth.service';
import { Component, inject } from '@angular/core';
import { SessionsFormComponent } from '../../components/sessions-form/sessions-form.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  imports: [SessionsFormComponent],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss',
})
export class SignupComponent {
  signup: FormGroup;
  private readonly router = inject(Router);
  private readonly http = inject(HttpClient);
  private readonly fb = inject(FormBuilder);
  private readonly sessionService = inject(AuthService);

  message: string = '';

  constructor() {
    this.signup = this.fb.group({
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
  }

  onSubmit() {
    if (this.signup.valid) {
      const sessionData = this.signup.value;
      this.sessionService.createSession(sessionData).subscribe((response) => {
        alert('Vous êtes inscrit avec succès.');
        this.sessionService.authenticate({
          email: sessionData.email,
          password: sessionData.password,
        });
      });
    } else {
      console.error('Form is invalid');
    }
  }
}
