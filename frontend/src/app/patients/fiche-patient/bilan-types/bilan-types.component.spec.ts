import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BilanTypesComponent } from './bilan-types.component';

describe('BilanTypesComponent', () => {
  let component: BilanTypesComponent;
  let fixture: ComponentFixture<BilanTypesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BilanTypesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BilanTypesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
