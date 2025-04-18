import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  constructor(private router: Router) {}
  goToSignup() {
    this.router.navigate(['/signup']);
  }
  goToSignin() {
    this.router.navigate(['/signin']);
  }
}
