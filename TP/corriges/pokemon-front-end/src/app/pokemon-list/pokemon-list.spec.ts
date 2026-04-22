import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokemonList } from './pokemon-list';

describe('PokemonList', () => {
  let component: PokemonList;
  let fixture: ComponentFixture<PokemonList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PokemonList],
    }).compileComponents();

    fixture = TestBed.createComponent(PokemonList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
