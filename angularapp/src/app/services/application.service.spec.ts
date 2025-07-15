import { TestBed } from '@angular/core/testing';

import { ApplicationService } from './application.service';
import { HttpClientModule } from '@angular/common/http';

describe('ApplicationService', () => {
  let service: ApplicationService;

  beforeEach(() => {
    TestBed.configureTestingModule({imports: [HttpClientModule]});
    service = TestBed.inject(ApplicationService);
  }); 
 
  fit('Frontend_day35_should_create_application_service', () => {
    expect(service).toBeTruthy();
  });
});
