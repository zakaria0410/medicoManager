import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActesSoinsComponent } from './actes-soins.component';

describe('ActesSoinsComponent', () => {
  let component: ActesSoinsComponent;
  let fixture: ComponentFixture<ActesSoinsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActesSoinsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActesSoinsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
