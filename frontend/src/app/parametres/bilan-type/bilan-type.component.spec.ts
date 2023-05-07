import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BilanTypeComponent } from './bilan-type.component';

describe('BilanTypeComponent', () => {
  let component: BilanTypeComponent;
  let fixture: ComponentFixture<BilanTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BilanTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BilanTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
