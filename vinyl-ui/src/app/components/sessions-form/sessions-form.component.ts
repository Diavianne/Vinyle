import { CommonModule } from '@angular/common';
import { Component, Input, Output, EventEmitter } from '@angular/core';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
} from '@angular/forms';

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

  onSubmit() {
    if (this.formGroup.valid) {
      console.log(this.formGroup.value);
      this.formSubmit.emit();
    }
  }

  goBack() {
    window.history.back();
  }

  isInvalidAndTouchedOrDirty(control: AbstractControl): boolean {
    return control.invalid && (control.dirty || control.touched);
  }
}
