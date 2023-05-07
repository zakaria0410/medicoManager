import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CerificatsMedicauxSettingComponent } from './cerificats-medicaux-setting.component';

describe('CerificatsMedicauxSettingComponent', () => {
  let component: CerificatsMedicauxSettingComponent;
  let fixture: ComponentFixture<CerificatsMedicauxSettingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CerificatsMedicauxSettingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CerificatsMedicauxSettingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
