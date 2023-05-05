import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditionCertificatComponent } from './edition-certificat.component';

describe('EditionCertificatComponent', () => {
  let component: EditionCertificatComponent;
  let fixture: ComponentFixture<EditionCertificatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditionCertificatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditionCertificatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
