import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DispositifMedicalComponent } from './dispositif-medical.component';

describe('DispositifMedicalComponent', () => {
  let component: DispositifMedicalComponent;
  let fixture: ComponentFixture<DispositifMedicalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DispositifMedicalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DispositifMedicalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
