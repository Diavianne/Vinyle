import { inject, Injectable } from '@angular/core';
import { Vinyl } from './vinyl.service';
import { Customer } from './customer.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface RentalItem {
  vinyl: Vinyl;
}
export interface Rental {
  id: number;
  customerEmail: string;
  items: RentalItem[];
  status: string;
}

@Injectable({
  providedIn: 'root',
})
export class RentalService {
  private readonly http = inject(HttpClient);
  private readonly apiUrl = 'http://localhost:8080/rentals';

  searchCustomerByEmail(email: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(
      `${this.apiUrl}/customers/search?email=${email}`
    );
  }

  searchVinylsByTitle(title: string): Observable<Vinyl[]> {
    return this.http.get<Vinyl[]>(
      `${this.apiUrl}/vinyls/search?title=${title}`
    );
  }

  createRental(rentalData: Rental): Observable<Rental> {
    return this.http.post<Rental>(this.apiUrl, rentalData);
  }

  addVinylToRental(email: string, vinylId: number): Observable<Rental> {
    return this.http.post<Rental>(`${this.apiUrl}/add-vinyl`, {
      email,
      vinylId,
    });
  }

  validateRental(rentalId: number): Observable<Rental> {
    return this.http.post<Rental>(`${this.apiUrl}/${rentalId}/validate`, {});
  }
}
