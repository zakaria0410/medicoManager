import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TempsAttenteMoyenComponent } from './temps-attente-moyen.component';

describe('TempsAttenteMoyenComponent', () => {
  let component: TempsAttenteMoyenComponent;
  let fixture: ComponentFixture<TempsAttenteMoyenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TempsAttenteMoyenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TempsAttenteMoyenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
