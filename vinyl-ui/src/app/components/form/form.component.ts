import { VinylService } from './../../services/vinyl.service';
import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormGroup,
  FormControl,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

import { Vinyl } from '../../services/vinyl.service';

@Component({
  selector: 'app-form',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.scss',
})
export class FormComponent implements OnInit {
  formGroup!: FormGroup;
  vinyls: Vinyl[] = [];
  showAddForm = false;
  editingVinyl: Vinyl | null = null;

  private vinylService = inject(VinylService);

  ngOnInit() {
    this.formGroup = new FormGroup({
      title: new FormControl('', Validators.required),
      artist: new FormControl('', Validators.required),
      year: new FormControl('', [
        Validators.required,
        Validators.pattern(/^\d{4}$/),
      ]),
      image: new FormControl(null),
    });
    this.loadVinyls();
  }

  loadVinyls(): void {
    this.vinylService.getVinyls().subscribe({
      next: (data) => {
        this.vinyls = data;
        console.log('Liste des vinyles:', this.vinyls);
      },
      error: (error) => {
        console.error('Erreur lors du chargement des vinyles', error);
      },
    });
  }

  onSubmit() {
    if (this.formGroup.valid) {
      const formData = new FormData();

      formData.append('title', this.formGroup.get('title')?.value);
      formData.append('artist', this.formGroup.get('artist')?.value);
      formData.append('year', this.formGroup.get('year')?.value);

      // Ajoutez le fichier seulement s'il est présent
      const imageFile = this.formGroup.get('image')?.value;
      if (imageFile) {
        formData.append('image', imageFile);
      }

      console.log("Données envoyées à l'API :", formData);
      if (this.editingVinyl) {
        // Si on édite un vinyle existant
        this.vinylService
          .updateVinyl(this.editingVinyl.id!, formData)
          .subscribe({
            next: (updatedVinyl) => {
              alert('Vinyle mis à jour avec succès');

              this.vinyls = this.vinyls.map((v) =>
                v.id === updatedVinyl.id ? updatedVinyl : v
              );
              this.loadVinyls();
              this.cancelForm();
            },
            error: (err) => {
              console.error('Erreur lors de la mise à jour du vinyle :', err);
            },
          });
      } else {
        // Si on ajoute un nouveau vinyle
        this.vinylService.createVinyl(formData).subscribe({
          next: (newVinyl) => {
            alert('Vinyle ajouté avec succès');
            this.vinyls.push(newVinyl); // Ajout à la liste locale
            this.cancelForm();
          },
          error: (err) => {
            console.error("Erreur lors de l'ajout du vinyle :", err);
          },
        });
      }
    }
  }

  onFileSelected(event: Event) {
    const file = (event.target as HTMLInputElement).files?.[0];
    if (file) {
      this.formGroup.patchValue({ image: file });
      this.formGroup.get('image')?.updateValueAndValidity();
    }
  }

  editVinyl(vinyl: Vinyl) {
    this.editingVinyl = vinyl;
    this.formGroup.patchValue({
      title: vinyl.title,
      artist: vinyl.artist,
      year: vinyl.year,
      image: null,
    });
    this.showAddForm = true;
  }

  deleteVinyl(vinyl: Vinyl) {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce vinyle ?')) {
      this.vinylService.deleteVinyl(vinyl.id!).subscribe({
        next: () => {
          console.log('Vinyle supprimé avec succès :', vinyl);
          const index = this.vinyls.indexOf(vinyl);
          if (index > -1) {
            this.vinyls.splice(index, 1);
          }
        },
        error: (err) => {
          console.error('Erreur lors de la suppression du vinyle :', err);
        },
      });
    }
  }

  getImageUrl(imageId: string): string {
    const baseUrl = 'http://localhost:8080/uploads/dest';
    return `${baseUrl}${imageId}`;
  }

  cancelForm() {
    this.showAddForm = false;
    this.editingVinyl = null;
    this.formGroup.reset();
  }
}
