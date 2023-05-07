import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DepensesSettingsComponent } from './depenses-settings.component';

describe('DepensesSettingsComponent', () => {
  let component: DepensesSettingsComponent;
  let fixture: ComponentFixture<DepensesSettingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DepensesSettingsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DepensesSettingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
