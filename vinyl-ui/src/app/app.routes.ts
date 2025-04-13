import { Routes } from '@angular/router';
import { SignupComponent } from './sessions/signup/signup.component';

export const routes: Routes = [
  { path: '', redirectTo: 'signup', pathMatch: 'full' },
  { path: 'signup', component: SignupComponent },
];
