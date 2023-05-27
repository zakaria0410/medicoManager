import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParametrageCertificatMedicalComponent } from './parametrage-certificat-medical.component';

describe('ParametrageCertificatMedicalComponent', () => {
  let component: ParametrageCertificatMedicalComponent;
  let fixture: ComponentFixture<ParametrageCertificatMedicalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParametrageCertificatMedicalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ParametrageCertificatMedicalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
