import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatierePremiereComponent } from './matiere-premiere.component';

describe('MatierePremiereComponent', () => {
  let component: MatierePremiereComponent;
  let fixture: ComponentFixture<MatierePremiereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MatierePremiereComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MatierePremiereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
