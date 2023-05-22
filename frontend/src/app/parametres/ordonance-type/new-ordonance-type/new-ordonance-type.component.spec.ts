import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewOrdonanceTypeComponent } from './new-ordonance-type.component';

describe('NewOrdonanceTypeComponent', () => {
  let component: NewOrdonanceTypeComponent;
  let fixture: ComponentFixture<NewOrdonanceTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewOrdonanceTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewOrdonanceTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
