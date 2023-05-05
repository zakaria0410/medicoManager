import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewActeSoinComponent } from './new-acte-soin.component';

describe('NewActeSoinComponent', () => {
  let component: NewActeSoinComponent;
  let fixture: ComponentFixture<NewActeSoinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewActeSoinComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewActeSoinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
