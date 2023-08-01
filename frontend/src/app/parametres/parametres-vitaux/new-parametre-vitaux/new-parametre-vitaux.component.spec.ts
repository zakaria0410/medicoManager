import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewParametreVitauxComponent } from './new-parametre-vitaux.component';

describe('NewParametreVitauxComponent', () => {
  let component: NewParametreVitauxComponent;
  let fixture: ComponentFixture<NewParametreVitauxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewParametreVitauxComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewParametreVitauxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
