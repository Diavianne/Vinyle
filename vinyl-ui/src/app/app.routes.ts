import { Routes } from '@angular/router';
import { SignupComponent } from './sessions/signup/signup.component';
import { SigninComponent } from './sessions/signin/signin.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'signup', component: SignupComponent },
  { path: 'signin', component: SigninComponent },
];
