import { Routes } from '@angular/router';
import { SignupComponent } from './sessions/signup/signup.component';
import { SigninComponent } from './sessions/signin/signin.component';
import { HomeComponent } from './pages/home/home.component';
import { FormComponent } from './components/form/form.component';
import { CustomerProfilComponent } from './components/customer-profil/customer-profil.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { RentalComponent } from './components/rental/rental.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, title: 'Accueil' },
  { path: 'signup', component: SignupComponent, title: 'Inscription' },
  { path: 'signin', component: SigninComponent, title: 'Connexion' },
  {
    path: 'dashboard',
    component: DashboardComponent,
    title: 'Tableau de bord',
  },
  // children: [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  {
    path: 'dashboard',
    component: DashboardComponent,
    title: 'Tableau de bord',
  },
  { path: 'form', component: FormComponent, title: 'Vinyle' },
  {
    path: 'customer-profil',
    component: CustomerProfilComponent,
    title: 'Client',
  },
  { path: 'sidebar', component: SidebarComponent, title: 'Sidebar' },
  { path: 'rental', component: RentalComponent, title: 'Location' },
  // ],
  // },
];
