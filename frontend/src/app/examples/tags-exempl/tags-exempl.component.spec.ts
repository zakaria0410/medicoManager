import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TagsExemplComponent } from './tags-exempl.component';

describe('TagsExemplComponent', () => {
  let component: TagsExemplComponent;
  let fixture: ComponentFixture<TagsExemplComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TagsExemplComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TagsExemplComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
