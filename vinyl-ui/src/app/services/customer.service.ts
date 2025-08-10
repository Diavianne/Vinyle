import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
export interface Customer {
  id?: number;
  name: string;
  email: string;
  city: string;
}

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  private readonly apiUrl = environment.apiUrl + '/customers';
  private readonly http = inject(HttpClient);

  createCustomer(customerData: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.apiUrl, customerData);
  }

  updateCustomer(id: number, customerData: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.apiUrl}/${id}`, customerData);
  }

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.apiUrl);
  }

  getCustomerByEmail(email: string): Observable<Customer> {
    return this.http.get<Customer>(`${this.apiUrl}?email=${email}`);
  }

  deleteCustomer(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
