import { Customer, CustomerService } from './../../services/customer.service';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

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

  ngOnInit() {
    this.formGroup = new FormGroup({
      name: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl(''),
    });
    this.loadCustomers();
  }

  loadCustomers(): void {
    this.customerService.getCustomers().subscribe({
      next: (data) => {
        this.customers = data;
        console.log('Liste des clients:', this.customers);
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
          console.log('Client supprimé avec succès', customer);
          const index = this.customers.indexOf(customer);
          if (index > 1) {
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
      address: customer.address,
    });
    this.showAddForm = true;
  }

  onSubmit() {
    if (this.formGroup.valid) {
      const customerData: Customer = {
        name: this.formGroup.get('name')?.value,
        email: this.formGroup.get('email')?.value,
        address: this.formGroup.get('address')?.value,
      };

      console.log("Données envoyées à l'API :", customerData);

      if (this.editingCustomer) {
        this.customerService
          .updateCustomer(this.editingCustomer.id!, customerData)
          .subscribe({
            next: (updateCustomer) => {
              console.log('Client mis à jour avec succès', updateCustomer);
              const index = this.customers.findIndex(
                (customer) => customer.id === this.editingCustomer.id
              );
              if (index !== -1) {
                this.customers[index] = updateCustomer;
              }
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
            console.log('Client créé avec succès', newCustomer);
            this.customers.push(newCustomer);
            this.loadCustomers();
            this.cancelForm();
          },
          error: (err) => {
            console.error('Erreur lors de la création du client', err);
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
