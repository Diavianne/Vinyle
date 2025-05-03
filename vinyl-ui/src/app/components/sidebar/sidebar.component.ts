import { Component, inject, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
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
  imports: [CommonModule, RouterModule],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss',
})
export class SidebarComponent {
  public menuItems: Array<Menu> = [
    {
      id: '1',
      titre: 'LISTER',
      icon: 'fa-solid fa-list-ul',
      url: './form.component.html',
    },
    {
      id: '2',
      titre: 'AJOUTER',
      icon: 'a-solid fa-plus',
      url: './form.component.html',
    },
    {
      id: '3',
      titre: 'MODIFIER',
      icon: 'fa-solid fa-pen',
      url: '',
    },
    {
      id: '4',
      titre: 'SUPPRIMER',
      icon: 'fa-solid fa-trash',
      url: '',
    },
  ];

  private lastSelectedMenu: Menu | undefined;

  private router = inject(Router);

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
