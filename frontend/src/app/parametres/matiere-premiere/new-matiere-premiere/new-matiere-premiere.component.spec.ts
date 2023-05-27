import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewMatierePremiereComponent } from './new-matiere-premiere.component';

describe('NewMatierePremiereComponent', () => {
  let component: NewMatierePremiereComponent;
  let fixture: ComponentFixture<NewMatierePremiereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewMatierePremiereComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewMatierePremiereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
