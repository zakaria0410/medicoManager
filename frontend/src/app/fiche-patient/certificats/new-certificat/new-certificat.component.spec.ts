import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCertificatComponent } from './new-certificat.component';

describe('NewCertificatComponent', () => {
  let component: NewCertificatComponent;
  let fixture: ComponentFixture<NewCertificatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewCertificatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCertificatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
