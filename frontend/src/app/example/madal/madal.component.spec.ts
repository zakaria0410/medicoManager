import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MadalComponent } from './madal.component';

describe('MadalComponent', () => {
  let component: MadalComponent;
  let fixture: ComponentFixture<MadalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MadalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MadalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
