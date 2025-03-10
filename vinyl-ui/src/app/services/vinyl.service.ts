import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Vinyl } from '../models/vinyl.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class VinylService {
  private vinyls: Vinyl[] = [];

  getVinyls(): Observable<Vinyl[]> {
    return of(this.vinyls);
  }

  createVinyl(vinyl: Vinyl): Observable<Vinyl> {
    const newVinyl = { ...vinyl, id: Date.now() };
    this.vinyls.push(newVinyl);
    return of(newVinyl);
  }

  updateVinyl(vinyl: Vinyl): Observable<Vinyl> {
    const index = this.vinyls.findIndex((v) => v.id === vinyl.id);
    if (index !== -1) {
      this.vinyls[index] = vinyl;
    }
    return of(vinyl);
  }

  deleteVinyl(id: number): Observable<void> {
    this.vinyls = this.vinyls.filter((v) => v.id !== id);
    return of(void 0);
  }
}
// export class VinylService {
//   private apiUrl = 'http://localhost:8080/vinyls';

//   constructor(private http: HttpClient) {}

//   getVinyls(): Observable<Vinyl[]> {
//     return this.http.get<Vinyl[]>(this.apiUrl);
//   }

//   createVinyl(vinyl: Vinyl): Observable<Vinyl> {
//     return this.http.post<Vinyl>(this.apiUrl, vinyl);
//   }

//   updateVinyl(vinyl: Vinyl): Observable<Vinyl> {
//     return this.http.put<Vinyl>(`${this.apiUrl}/${vinyl.id}`, vinyl);
//   }

//   deleteVinyl(id: number): Observable<void> {
//     return this.http.delete<void>(`${this.apiUrl}/${id}`);
//   }
// }
