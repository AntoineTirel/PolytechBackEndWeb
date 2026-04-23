import { Component, inject } from '@angular/core';
import { PokemonDTO } from '../@types/Pokemon';
import { PokemonService } from '../pokemon-service';

@Component({
  selector: 'app-pokemon',
  imports: [],
  templateUrl: './pokemon.html',
  styleUrl: './pokemon.css',
})
export class Pokemon {
  private readonly pokemonService = inject(PokemonService);
  protected pokemon: PokemonDTO | undefined;

  constructor() {
    this.pokemonService.getPokemonList
  }
}
