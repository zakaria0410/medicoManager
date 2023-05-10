import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalleAttenteComponent } from './salle-attente.component';

describe('SalleAttenteComponent', () => {
  let component: SalleAttenteComponent;
  let fixture: ComponentFixture<SalleAttenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalleAttenteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SalleAttenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
