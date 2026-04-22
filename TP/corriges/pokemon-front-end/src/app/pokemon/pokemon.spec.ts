import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pokemon } from './pokemon';

describe('Pokemon', () => {
  let component: Pokemon;
  let fixture: ComponentFixture<Pokemon>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Pokemon],
    }).compileComponents();

    fixture = TestBed.createComponent(Pokemon);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
