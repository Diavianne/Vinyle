import {
  FormGroup,
  ReactiveFormsModule,
  FormControl,
  Validators,
} from '@angular/forms';
import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Rental, RentalService } from '../../services/rental.service';
import { Vinyl, VinylService } from '../../services/vinyl.service';

@Component({
  selector: 'app-rental',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './rental.component.html',
  styleUrl: './rental.component.scss',
})
export class RentalComponent implements OnInit {
  formGroup!: FormGroup;
  rental: Rental | null = null;
  errorMessage = '';
  vinylResults: Vinyl[] = [];
  selectedVinylId: number | null = null;
  cart: Vinyl[] = [];

  private rentalService = inject(RentalService);
  private vinylService = inject(VinylService);

  ngOnInit() {
    this.formGroup = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      vinylSearch: new FormControl('', [Validators.required]),
    });
  }

  addVinyl() {
    this.errorMessage = '';
    const email = this.formGroup.get('email')?.value;
    const vinylId = this.selectedVinylId;

    if (!email || !vinylId) {
      this.errorMessage =
        'Veuillez fournir un e-mail et sélectionner un vinyle.';
      return;
    }

    this.rentalService.addVinylToRental(email, vinylId).subscribe({
      next: (data) => (this.rental = data),
      error: (err) =>
        (this.errorMessage = err.error?.message || 'Erreur lors de l’ajout'),
    });
  }

  validateRental() {
    if (!this.rental) return;
    this.rentalService.validateRental(this.rental.id).subscribe({
      next: (data) => (this.rental = data),
      error: () => (this.errorMessage = 'Erreur lors de la validation'),
    });
  }

  onVinylSearch() {
    const query = this.formGroup.get('vinylSearch')?.value || '';
    this.selectedVinylId = null; // reset selection on new search
    if (query.length < 2) {
      this.vinylResults = [];
      return;
    }
    this.vinylService.searchVinyls(query).subscribe((results) => {
      this.vinylResults = results;
    });
  }

  selectVinyl(vinyl: Vinyl) {
    this.formGroup.patchValue({
      vinylSearch: `${vinyl.title} – ${vinyl.artist}`,
    });
    this.selectedVinylId = vinyl.id ?? null; // <-- Corrige ici
    this.vinylResults = [];
  }

  addToCart() {
    if (this.selectedVinylId) {
      const vinyl = this.vinylResults.find(
        (v) => v.id === this.selectedVinylId
      );
      if (vinyl && !this.cart.some((v) => v.id === vinyl.id)) {
        this.cart.push(vinyl);
      }
      this.formGroup.patchValue({ vinylSearch: '' });
      this.selectedVinylId = null;
    }
  }

  removeFromCart(vinyl: Vinyl) {
    this.cart = this.cart.filter((v) => v.id !== vinyl.id);
  }

  addVinylsToRental() {
    this.errorMessage = '';
    const email = this.formGroup.get('email')?.value;
    if (!email || this.cart.length === 0) {
      this.errorMessage =
        'Veuillez sélectionner un client et au moins un vinyle.';
      return;
    }
    // Appelle le service pour chaque vinyle du panier
    this.cart.forEach((vinyl, index) => {
      this.rentalService.addVinylToRental(email, vinyl.id).subscribe({
        next: (data) => {
          this.rental = data;
          if (index === this.cart.length - 1) this.cart = [];
        },
        error: (err) =>
          (this.errorMessage = err.error?.message || 'Erreur lors de l’ajout'),
      });
    });
  }
}
