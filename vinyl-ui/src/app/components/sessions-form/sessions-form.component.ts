import { CommonModule } from '@angular/common';
import { Component, Input, Output, EventEmitter, inject } from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sessions-form',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './sessions-form.component.html',
  styleUrl: './sessions-form.component.scss',
})
export class SessionsFormComponent {
  @Input() formGroup = new FormGroup({
    firstname: new FormControl(''),
    lastname: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
  });
  @Input() title = '';
  @Input() titleSubmit = '';
  @Output() formSubmit = new EventEmitter<void>();
  @Input() showNameFields: boolean = false;
  showPassword = false;
  router = inject(Router);

  onSubmit() {
    if (this.formGroup.valid) {
      this.formSubmit.emit();
    }
  }

  goBack() {
    this.router.navigate(['/home']);
  }

  isInvalidAndTouchedOrDirty(control: AbstractControl): boolean {
    return control.invalid && (control.dirty || control.touched);
  }

  togglePasswordVisibility() {
    this.showPassword = !this.showPassword;
  }
}
