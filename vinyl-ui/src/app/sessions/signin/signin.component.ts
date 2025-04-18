import { Component } from '@angular/core';
import { SessionsFormComponent } from '../../components/sessions-form/sessions-form.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-signin',
  imports: [SessionsFormComponent],
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.scss',
})
export class SigninComponent {
  signin: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.signin = this.fb.group({
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }
  onSubmit() {
    if (this.signin.valid) {
      const sessionData = {
        firstname: this.signin.value.firstname,
        lastname: this.signin.value.lastname,
        password: this.signin.value.password,
      };
      console.log('Form submitted:', sessionData);
      this.http
        .post('http://localhost:8080/employees/authenticate', sessionData)
        .subscribe((response) => {
          console.log('Session opened successfully:', response);
          console.log('Form submitted:', this.signin.value);
        });
    } else {
      console.log('Form is invalid');
    }
  }
}
