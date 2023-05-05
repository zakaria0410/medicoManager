import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParametresVitauxComponent } from './parametres-vitaux.component';

describe('ParametresVitauxComponent', () => {
  let component: ParametresVitauxComponent;
  let fixture: ComponentFixture<ParametresVitauxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParametresVitauxComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ParametresVitauxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
