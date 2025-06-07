import { Component, inject } from '@angular/core';
import { SessionsFormComponent } from '../../components/sessions-form/sessions-form.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-signin',
  imports: [SessionsFormComponent],
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.scss',
})
export class SigninComponent {
  signin: FormGroup;
  private readonly router = inject(Router);
  private readonly fb = inject(FormBuilder);
  private readonly sessionService = inject(AuthService);

  constructor() {
    this.signin = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
  }

  signIn() {
    if (this.signin.valid) {
      const credentials = this.signin.value;
      this.sessionService.authenticate(credentials);
    } else {
      console.error('Formulaire invalide');
    }
  }
}
