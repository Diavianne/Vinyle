import { Component, NgModule } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { HeaderComponent } from './components/header/header.component';
import { FormComponent } from './components/form/form.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, SidebarComponent, HeaderComponent, FormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'vinyl-ui';
}
