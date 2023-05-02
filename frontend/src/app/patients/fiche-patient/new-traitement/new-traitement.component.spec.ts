import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewTraitementComponent } from './new-traitement.component';

describe('NewTraitementComponent', () => {
  let component: NewTraitementComponent;
  let fixture: ComponentFixture<NewTraitementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewTraitementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewTraitementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
