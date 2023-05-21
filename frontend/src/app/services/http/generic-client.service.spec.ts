import { TestBed } from '@angular/core/testing';

import { GenericClientService } from './generic-client.service';

describe('GenericClientService', () => {
  let service: GenericClientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GenericClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
