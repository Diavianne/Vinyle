import {
  FormGroup,
  ReactiveFormsModule,
  FormControl,
  Validators,
} from '@angular/forms';
import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Rental, RentalService } from '../../services/rental.service';
import { Vinyl } from '../../services/vinyl.service';
import { Customer } from '../../services/customer.service';

@Component({
  selector: 'app-rental',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './rental.component.html',
  styleUrl: './rental.component.scss',
})
export class RentalComponent implements OnInit {
  rentals: Rental[] = [];
  customers: Customer[] = [];
  vinyls: Vinyl[] = [];
  showAddForm = false;

  formGroup!: FormGroup;
  vinylResults: Vinyl[] = [];
  selectedVinyls: Vinyl[] = [];
  customerFound = false;
  customerError = false;

  private rentalService = inject(RentalService);
  private customerService = inject(RentalService);
  private vinylService = inject(RentalService);

  ngOnInit() {
    this.formGroup = new FormGroup({
      customerEmail: new FormControl('', [
        Validators.required,
        Validators.email,
      ]),
      vinylSearch: new FormControl(''),
      returnDate: new FormControl(''),
    });
  }

  searchCustomer(): void {
    const email = this.formGroup.get('customerEmail')?.value;
    if (email) {
      this.rentalService.searchCustomerByEmail(email).subscribe({
        next: () => {
          this.customerFound = true;
          this.customerError = false;
        },
        error: () => {
          this.customerFound = false;
          this.customerError = true;
        },
      });
    }
  }

  searchVinyl(): void {
    const title = this.formGroup.get('vinylSearch')?.value;
    if (title && title.length > 2) {
      this.rentalService.searchVinylsByTitle(title).subscribe({
        next: (data: Vinyl[]) => (this.vinylResults = data),
        error: () => (this.vinylResults = []),
      });
    }
  }

  addVinyl(vinyl: Vinyl): void {
    if (!this.selectedVinyls.find((v) => v.id === vinyl.id)) {
      this.selectedVinyls.push(vinyl);
    }
  }

  removeVinyl(vinyl: Vinyl): void {
    this.selectedVinyls = this.selectedVinyls.filter((v) => v.id !== vinyl.id);
  }

  onSubmit(): void {
    if (!this.customerFound || this.selectedVinyls.length === 0) return;

    const rentalData: Rental = {
      customerEmail: this.formGroup.get('customerEmail')?.value,
      returnDate: this.formGroup.get('returnDate')?.value,
      vinylIds: this.formGroup.get('vinylSearch')?.value,
    };

    this.rentalService.createRental(rentalData).subscribe({
      next: () => {
        alert('Location créée avec succès.');
        this.formGroup.reset();
        this.selectedVinyls = [];
        this.vinylResults = [];
        this.customerFound = false;
      },
      error: (err: Error[]) => {
        console.error('Erreur lors de la création', err);
        alert('Échec de la création de la location.');
      },
    });
  }
}
