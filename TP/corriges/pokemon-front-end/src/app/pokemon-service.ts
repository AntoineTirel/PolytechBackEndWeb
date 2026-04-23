import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PokemonDTO } from './@types/Pokemon';

@Injectable({
  providedIn: 'root',
})
export class PokemonService {
  private readonly http = inject(HttpClient);

  getPokemonList(): Observable<PokemonDTO[]> {
    return this.http.get<PokemonDTO[]>('/api/pokemon');
  }

  getPokemonById(id: number): Observable<PokemonDTO> {
    return this.http.get<PokemonDTO>('/api/pokemon/id/' + id);
  }
}
