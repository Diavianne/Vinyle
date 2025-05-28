import { Component } from '@angular/core';
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
  imports: [RouterLink],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
})
export class HeaderComponent {
  public menuItems: Array<Menu> = [
    {
      id: '1',
      titre: 'VINYLE',
      icon: 'bi bi-vinyl-fill',
      url: './form.component.html',
    },
    {
      id: '2',
      titre: 'CLIENT',
      icon: 'a-solid fa-plus',
      url: './customer-profil.component.html',
    },
    {
      id: '3',
      titre: 'LOCATION',
      icon: 'fa-solid fa-pen',
      url: './rental.component.html',
    },
  ];
}
