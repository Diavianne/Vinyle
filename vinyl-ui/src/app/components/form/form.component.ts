import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormGroup,
  FormControl,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { VinylService } from '../../services/vinyl.service';
import { Vinyl } from '../../models/vinyl.model';

@Component({
  selector: 'app-form',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.scss',
})
export class FormComponent implements OnInit {
  formGroup!: FormGroup;
  vinyls: any[] = []; // Liste des vinyles
  showAddForm = false;
  editingVinyl: any = null;

  constructor(private vinylService: VinylService) {}

  ngOnInit() {
    // Initialisation du formulaire
    this.formGroup = new FormGroup({
      title: new FormControl('', Validators.required),
      artist: new FormControl('', Validators.required),
      year: new FormControl('', [
        Validators.required,
        Validators.pattern(/^\d{4}$/),
      ]),
      image: new FormControl(null),
    });
  }

  onSubmit() {
    if (this.formGroup.valid) {
      const formData = new FormData();

      // Ajoutez les champs au FormData
      formData.append('title', this.formGroup.get('title')?.value);
      formData.append('artist', this.formGroup.get('artist')?.value);
      formData.append('year', this.formGroup.get('year')?.value);

      // Ajoutez le fichier seulement s'il est présent
      const imageFile = this.formGroup.get('image')?.value;
      if (imageFile) {
        formData.append('image', imageFile);
      }

      console.log("Données envoyées à l'API :", formData);

      this.vinylService.createVinyl(formData).subscribe({
        next: (newVinyl) => {
          console.log('Vinyle ajouté avec succès :', newVinyl);
          this.vinyls.push(newVinyl); // Ajout à la liste locale
          this.cancelForm();
        },
        error: (err) => {
          console.error("Erreur lors de l'ajout du vinyle :", err);
        },
      });
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
    this.formGroup.patchValue(vinyl);
    this.showAddForm = true;
  }

  deleteVinyl(vinyl: Vinyl) {
    const index = this.vinyls.indexOf(vinyl);
    if (index > -1) {
      this.vinyls.splice(index, 1);
    }
  }

  cancelForm() {
    this.showAddForm = false;
    this.editingVinyl = null;
    this.formGroup.reset();
  }
}
