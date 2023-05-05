import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewBilanComponent } from './new-bilan.component';

describe('NewBilanComponent', () => {
  let component: NewBilanComponent;
  let fixture: ComponentFixture<NewBilanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewBilanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewBilanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
