import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputAutocompleteStaticComponent } from './input-autocomplete-static.component';

describe('InputAutocompleteStaticComponent', () => {
  let component: InputAutocompleteStaticComponent;
  let fixture: ComponentFixture<InputAutocompleteStaticComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InputAutocompleteStaticComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InputAutocompleteStaticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
