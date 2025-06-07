import { Routes } from '@angular/router';
import { SignupComponent } from './sessions/signup/signup.component';
import { SigninComponent } from './sessions/signin/signin.component';
import { HomeComponent } from './pages/home/home.component';
import { FormComponent } from './components/form/form.component';
import { CustomerProfilComponent } from './components/customer-profil/customer-profil.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { RentalComponent } from './components/rental/rental.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { HeaderComponent } from './components/header/header.component';
import { authGuard } from './sessions/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, title: 'Accueil' },
  { path: 'signup', component: SignupComponent, title: 'Inscription' },
  { path: 'signin', component: SigninComponent, title: 'Connexion' },
  {
    path: 'dashboard',
    component: DashboardComponent,
    title: 'Tableau de bord',
    canMatch: [authGuard],
    children: [
      { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
      { path: 'form', component: FormComponent, title: 'Vinyle' },
      {
        path: 'customer-profil',
        component: CustomerProfilComponent,
        title: 'Client',
      },
      { path: 'rental', component: RentalComponent, title: 'Location' },
      { path: 'header', component: HeaderComponent, title: 'header' },
    ],
  },
  { path: '**', redirectTo: 'home' },
];
