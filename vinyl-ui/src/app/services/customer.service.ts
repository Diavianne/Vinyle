import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Customer {
  id?: number;
  name: string;
  email: string;
  address: string;
}

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  private readonly apiUrl = 'http://localhost:8080/customers';
  private readonly http = inject(HttpClient);

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.apiUrl);
  }

  createCustomer(customerData: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.apiUrl, customerData);
  }

  updateCustomer(id: number, customerData: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.apiUrl}/${id}`, customerData);
  }

  // getCustomerByEmail(email: string): Observable<Customer> {
  //   return this.http.get<Customer>(`${this.apiUrl}?email=${email}`);
  // }

  deleteCustomer(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
