import { inject } from '@angular/core';
import { CanMatchFn, Router } from '@angular/router';
import { AuthService } from './auth.service';

export const authGuard: CanMatchFn = (route, segments) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  const isConnected = authService.isAuthenticated();
  if (isConnected) {
    return true;
  }
  router.navigate(['/signin']);
  return false;
};
