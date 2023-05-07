import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewBilanTypeComponent } from './new-bilan-type.component';

describe('NewBilanTypeComponent', () => {
  let component: NewBilanTypeComponent;
  let fixture: ComponentFixture<NewBilanTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewBilanTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewBilanTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
