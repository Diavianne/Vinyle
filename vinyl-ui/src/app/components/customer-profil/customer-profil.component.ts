import { Customer, CustomerService } from './../../services/customer.service';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-customer-profil',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './customer-profil.component.html',
  styleUrl: './customer-profil.component.scss',
})
export class CustomerProfilComponent implements OnInit {
  formGroup!: FormGroup;
  customers: Customer[] = [];
  showAddForm = false;
  editingCustomer!: Customer;
  currentCustomers: Customer[] = [];

  private customerService = inject(CustomerService);
  private toastr = inject(ToastrService);

  ngOnInit() {
    this.formGroup = new FormGroup({
      name: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      city: new FormControl('', Validators.required),
    });
    this.loadCustomers();
  }

  loadCustomers(): void {
    this.customerService.getCustomers().subscribe({
      next: (data) => {
        this.customers = data;
      },
      error: (error) => {
        console.error('Erreur lors du chargement des clients', error);
      },
    });
  }

  deleteCustomer(customer: Customer) {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce client ?')) {
      this.customerService.deleteCustomer(customer.id!).subscribe({
        next: () => {
          const index = this.customers.indexOf(customer);
          if (index > -1) {
            this.customers.splice(index, 1);
          }
        },
        error: (err) => {
          console.error('Erreur lors de la suppression du client', err);
        },
      });
    }
  }
  editCustomer(customer: Customer) {
    this.editingCustomer = customer;
    this.formGroup.patchValue({
      name: customer.name,
      email: customer.email,
      city: customer.city,
    });
    this.showAddForm = true;
  }

  onSubmit() {
    if (this.formGroup.valid) {
      const customerData: Customer = {
        name: this.formGroup.get('name')?.value,
        email: this.formGroup.get('email')?.value,
        city: this.formGroup.get('city')?.value,
      };

      if (this.editingCustomer) {
        this.customerService
          .updateCustomer(this.editingCustomer.id!, customerData)
          .subscribe({
            next: (updateCustomer) => {
              const index = this.customers.findIndex(
                (customer) => customer.id === this.editingCustomer.id
              );
              if (index !== -1) {
                this.customers[index] = updateCustomer;
              }
              this.toastr.success('Client modifié avec succès');
              this.loadCustomers();
              this.cancelForm();
            },
            error: (err) => {
              console.error('Erreur lors de la mise à jour du client', err);
            },
          });
      } else {
        this.customerService.createCustomer(customerData).subscribe({
          next: (newCustomer) => {
            this.toastr.success('Client ajouté avec succès');
            this.loadCustomers();
            this.cancelForm();
          },
          error: (error) => {
            if (error.status === 409 || error.status === 401) {
              this.toastr.error('Cet email est déjà utilisé.');
            } else {
              this.toastr.error(
                "Une erreur est survenue lors de l'inscription."
              );
            }
          },
        });
      }
    }
  }

  cancelForm() {
    this.showAddForm = false;
    this.editingCustomer;
    this.formGroup.reset();
  }
}
