import {
  HttpEvent,
  HttpHandler,
  HttpHandlerFn,
  HttpHeaders,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

export function authInterceptor(
  req: HttpRequest<unknown>,
  next: HttpHandlerFn
) {
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
