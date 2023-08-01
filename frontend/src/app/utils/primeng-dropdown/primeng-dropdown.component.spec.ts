import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimengDropdownComponent } from './primeng-dropdown.component';

describe('PrimengDropdownComponent', () => {
  let component: PrimengDropdownComponent;
  let fixture: ComponentFixture<PrimengDropdownComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrimengDropdownComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrimengDropdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
