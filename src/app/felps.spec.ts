import { TestBed } from '@angular/core/testing';

import { Felps } from './felps';

describe('Felps', () => {
  let service: Felps;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Felps);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
