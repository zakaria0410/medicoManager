import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeTrialStatisticsComponent } from './home-trial-statistics.component';

describe('HomeTrialStatisticsComponent', () => {
  let component: HomeTrialStatisticsComponent;
  let fixture: ComponentFixture<HomeTrialStatisticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeTrialStatisticsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeTrialStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
