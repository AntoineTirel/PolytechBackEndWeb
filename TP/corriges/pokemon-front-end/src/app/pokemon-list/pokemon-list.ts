import { Component, inject } from '@angular/core';
import { PokemonDTO } from '../@types/Pokemon';
import { PokemonService } from '../pokemon-service';

@Component({
  selector: 'app-pokemon-list',
  imports: [],
  templateUrl: './pokemon-list.html',
  styleUrl: './pokemon-list.css',
})
export class PokemonList {
  private readonly pokemonService = inject(PokemonService);
  protected pokemonList: PokemonDTO[] = [];

  constructor() {
    this.pokemonService.getPokemonList().subscribe(pokemonList => this.pokemonList = pokemonList);
  }
}
