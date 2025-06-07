import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

export interface Vinyl {
  id?: number;
  title: string;
  artist: string;
  year: string;
  imageId: string;
}

@Injectable({
  providedIn: 'root',
})
export class VinylService {
  private readonly apiUrl = 'http://localhost:8080/vinyls';
  private readonly http = inject(HttpClient);

  getVinyls(): Observable<Vinyl[]> {
    return this.http.get<Vinyl[]>(this.apiUrl);
  }

  createVinyl(vinylData: FormData): Observable<Vinyl> {
    return this.http.post<Vinyl>(this.apiUrl, vinylData);
  }

  updateVinyl(id: number, vinylData: FormData): Observable<Vinyl> {
    return this.http.put<Vinyl>(`${this.apiUrl}/${id}`, vinylData);
  }

  deleteVinyl(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
