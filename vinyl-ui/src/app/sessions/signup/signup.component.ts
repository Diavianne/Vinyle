import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SessionService } from '../../services/session.service';
import { HttpClient } from '@angular/common/http';
import { SessionsFormComponent } from '../../components/sessions-form/sessions-form.component';

@Component({
  selector: 'app-signup',
  imports: [SessionsFormComponent],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss',
})
export class SignupComponent {
  signup: FormGroup;

  constructor(
    private fb: FormBuilder,
    private sessionService: SessionService,
    private http: HttpClient
  ) {
    this.signup = this.fb.group({
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
  }

  onSubmit() {
    if (this.signup.valid) {
      const sessionData = {
        firstname: this.signup.value.firstname,
        lastname: this.signup.value.lastname,
        password: this.signup.value.password,
      };
      console.log('Form submitted:', sessionData);
      this.sessionService.createSession(sessionData).subscribe((response) => {
        console.log('Session created successfully:', response);
        console.log('Form submitted:', this.signup.value);
      });
    } else {
      console.log('Form is invalid');
    }
  }
}
