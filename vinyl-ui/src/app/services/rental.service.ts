import { inject, Injectable } from '@angular/core';
import { Vinyl } from './vinyl.service';
import { Customer } from './customer.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Rental {
  customerEmail: string;
  vinylIds: number[];
  returnDate: string;
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
}
