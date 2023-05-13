import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectStaticComponent } from './select-static.component';

describe('SelectStaticComponent', () => {
  let component: SelectStaticComponent;
  let fixture: ComponentFixture<SelectStaticComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SelectStaticComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectStaticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
