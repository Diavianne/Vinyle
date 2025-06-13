import { HttpEvent, HttpHandlerFn, HttpRequest } from '@angular/common/http';
import { inject } from '@angular/core';
import { AuthService } from './auth.service';

export function authInterceptor(
  req: HttpRequest<unknown>,
  next: HttpHandlerFn
) {
  if (req.url.endsWith('/employees/authenticate')) {
    return next(req);
  }

  const authSer = inject(AuthService);
  const token = authSer.getAuthToken();
  if (!token) {
    return next(req);
  }

  const finalRequest = req.clone({
    headers: req.headers.set('Authorization', `Bearer ${token}`),
  });
  return next(finalRequest);
}
