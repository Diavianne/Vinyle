import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

export interface Menu {
  id?: string;
  titre?: string;
  icon?: string;
  url?: string;
  active?: boolean;
}

@Component({
  selector: 'app-sidebar',
  imports: [CommonModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss',
})
export class SidebarComponent {
  public menuItems: Array<Menu> = [
    {
      id: '1',
      titre: 'LISTER',
      icon: 'fas fa-chart-line',
      url: '',
    },
    {
      id: '2',
      titre: 'AJOUTER',
      icon: 'fa-solid fa-record-vinyl',
      url: '',
    },
    {
      id: '3',
      titre: 'MODIFIER',
      icon: 'fas fa-users',
      url: '',
    },
    {
      id: '4',
      titre: 'SUPPRIMER',
      icon: 'fa-solid fa-user',
      url: '',
    },
  ];

  private lastSelectedMenu: Menu | undefined;
  constructor(private router: Router) {}

  ngOnInit(): void {}

  navigate(menu: Menu): void {
    if (this.lastSelectedMenu) {
      this.lastSelectedMenu.active = false;
    }
    menu.active = true;
    this.lastSelectedMenu = menu;
    this.router.navigate([menu.url]);
  }
}
