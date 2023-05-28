import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewCertificatComponent } from './add-new-certificat.component';

describe('AddNewCertificatComponent', () => {
  let component: AddNewCertificatComponent;
  let fixture: ComponentFixture<AddNewCertificatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNewCertificatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewCertificatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
