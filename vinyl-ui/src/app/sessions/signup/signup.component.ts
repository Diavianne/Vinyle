import { SessionService } from '../../services/session.service';
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
  private readonly sessionService = inject(SessionService);

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
      console.log('Form submitted:', sessionData);
      this.sessionService.createSession(sessionData).subscribe((response) => {
        console.log('Session created successfully:', response);
        alert('Vous êtes inscrit avec succès.');
        this.router.navigate(['dashboard']);
      });
    } else {
      console.log('Form is invalid');
    }
  }
}
