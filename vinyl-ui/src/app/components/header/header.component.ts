import { AuthService } from '../../sessions/auth.service';
import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { RouterLink } from '@angular/router';

export interface Menu {
  id?: string;
  titre?: string;
  icon?: string;
  url?: string;
  active?: boolean;
}
@Component({
  selector: 'app-header',
  imports: [RouterLink, CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
})
export class HeaderComponent {
  SessionService = inject(AuthService);

  public menuItems: Array<Menu> = [
    {
      id: '1',
      titre: 'VINYLE',
      icon: 'bi bi-vinyl-fill',
      url: '/dashboard/form',
    },
    {
      id: '2',
      titre: 'CLIENT',
      icon: 'fa-solid fa-user',
      url: '/dashboard/customer-profil',
    },
    {
      id: '3',
      titre: 'LOCATION',
      icon: 'fa-solid fa-pen',
      url: '/dashboard/rental',
    },
  ];

  onLogout() {
    this.SessionService.logOut();
  }
}
