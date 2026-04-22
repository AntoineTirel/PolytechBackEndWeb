import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from './@types/Pokemon';

@Injectable({
  providedIn: 'root',
})
export class PokemonService {
  private readonly http = inject(HttpClient);

  getPokemonList(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>('/api/pokemon');
  }
}
