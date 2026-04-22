import { Component, inject } from '@angular/core';
import { PokemonService } from '../pokemon-service';
import { Pokemon } from '../@types/Pokemon';

@Component({
  selector: 'app-pokemon-list',
  imports: [],
  templateUrl: './pokemon-list.html',
  styleUrl: './pokemon-list.css',
})
export class PokemonList {
  private readonly pokemonService = inject(PokemonService);
  protected pokemonList: Pokemon[] = [];
  
  constructor() {
    this.pokemonService.getPokemonList().subscribe(pokemonList => this.pokemonList = pokemonList);
  }
}
