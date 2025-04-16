import { CommonModule } from '@angular/common';
import { Component, Input, Output, EventEmitter } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

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
    password: new FormControl(''),
  });
  @Input() title = '';
  @Output() formSubmit = new EventEmitter<any>();

  onSubmit() {
    if (this.formGroup.valid) {
      console.log(this.formGroup.value);
      this.formSubmit.emit();
    }
  }

  isInvalidAndTouchedOrDirty(control: any): boolean {
    return control.invalid && (control.dirty || control.touched);
  }
}
