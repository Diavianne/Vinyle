import { Routes } from '@angular/router';
import { SignupComponent } from './sessions/signup/signup.component';
import { SigninComponent } from './sessions/signin/signin.component';
import { HomeComponent } from './pages/home/home.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'signin', component: SigninComponent },
];
