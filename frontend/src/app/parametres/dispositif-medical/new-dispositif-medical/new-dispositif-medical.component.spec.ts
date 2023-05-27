import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewDispositifMedicalComponent } from './new-dispositif-medical.component';

describe('NewDispositifMedicalComponent', () => {
  let component: NewDispositifMedicalComponent;
  let fixture: ComponentFixture<NewDispositifMedicalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewDispositifMedicalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewDispositifMedicalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
