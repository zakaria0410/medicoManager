import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdonanceTypeComponent } from './ordonance-type.component';

describe('OrdonanceTypeComponent', () => {
  let component: OrdonanceTypeComponent;
  let fixture: ComponentFixture<OrdonanceTypeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdonanceTypeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrdonanceTypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
