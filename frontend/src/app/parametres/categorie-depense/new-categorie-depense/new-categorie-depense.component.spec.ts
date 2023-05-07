import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewCategorieDepenseComponent } from './new-categorie-depense.component';

describe('NewCategorieDepenseComponent', () => {
  let component: NewCategorieDepenseComponent;
  let fixture: ComponentFixture<NewCategorieDepenseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewCategorieDepenseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCategorieDepenseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
