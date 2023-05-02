import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShcemaDentaireComponent } from './shcema-dentaire.component';

describe('ShcemaDentaireComponent', () => {
  let component: ShcemaDentaireComponent;
  let fixture: ComponentFixture<ShcemaDentaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShcemaDentaireComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShcemaDentaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
