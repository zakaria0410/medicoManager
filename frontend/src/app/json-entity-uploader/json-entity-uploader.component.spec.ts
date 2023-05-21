import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JsonEntityUploaderComponent } from './json-entity-uploader.component';

describe('JsonEntityUploaderComponent', () => {
  let component: JsonEntityUploaderComponent;
  let fixture: ComponentFixture<JsonEntityUploaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JsonEntityUploaderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JsonEntityUploaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
