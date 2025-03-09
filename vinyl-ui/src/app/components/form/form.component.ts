import { Component, OnInit } from '@angular/core';
import { VinylService } from '../../services/vinyl.service';
import { CommonModule } from '@angular/common';
import { Vinyl } from '../../models/vinyl.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form',
  imports: [CommonModule, FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.scss',
})
export class FormComponent {
  vinyls: Vinyl[] = [];
  showAddForm = false;
  editingVinyl: Vinyl | null = null;
  currentVinyl: Vinyl = {
    title: '',
    artist: '',
    releaseYear: '',
    img: '',
    available: true,
  };

  constructor(private vinylService: VinylService) {}

  ngOnInit() {
    this.loadVinyls();
  }

  loadVinyls() {
    this.vinylService.getVinyls().subscribe((vinyls) => {
      this.vinyls = vinyls;
    });
  }

  onSubmit() {
    if (this.editingVinyl) {
      this.vinylService
        .updateVinyl({ ...this.currentVinyl, id: this.editingVinyl.id })
        .subscribe(() => {
          this.loadVinyls();
          this.cancelForm();
        });
    } else {
      this.vinylService.createVinyl(this.currentVinyl).subscribe(() => {
        this.loadVinyls();
        this.cancelForm();
      });
      console.log(this.currentVinyl);
    }
  }

  editVinyl(vinyl: Vinyl) {
    this.editingVinyl = vinyl;
    this.currentVinyl = { ...vinyl };
    this.showAddForm = true;
  }

  deleteVinyl(vinyl: Vinyl) {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce vinyle ?')) {
      this.vinylService.deleteVinyl(vinyl.id!).subscribe(() => {
        this.loadVinyls();
      });
    }
  }

  cancelForm() {
    this.showAddForm = false;
    this.editingVinyl = null;
    this.currentVinyl = {
      title: '',
      artist: '',
      releaseYear: '',
      img: '',
      available: true,
    };
  }
}
