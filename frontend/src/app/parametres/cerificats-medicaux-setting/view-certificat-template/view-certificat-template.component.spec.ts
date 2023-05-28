import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCertificatTemplateComponent } from './view-certificat-template.component';

describe('ViewCertificatTemplateComponent', () => {
  let component: ViewCertificatTemplateComponent;
  let fixture: ComponentFixture<ViewCertificatTemplateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewCertificatTemplateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCertificatTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
