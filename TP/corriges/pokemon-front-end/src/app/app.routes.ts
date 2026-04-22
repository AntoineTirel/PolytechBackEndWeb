import { Routes } from '@angular/router';
import { PokemonList } from './pokemon-list/pokemon-list';
import { Pokemon } from './pokemon/pokemon';

export const routes: Routes = [
    { path: 'list', component: PokemonList },
    { path: 'pokemon/:id', component: Pokemon },
];
