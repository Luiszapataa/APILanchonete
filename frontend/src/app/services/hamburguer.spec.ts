import { TestBed } from '@angular/core/testing';

import { Hamburguer } from './hamburguer';

describe('Hamburguer', () => {
  let service: Hamburguer;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Hamburguer);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
