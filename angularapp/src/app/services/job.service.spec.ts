import { TestBed } from '@angular/core/testing';

import { JobService } from './job.service';
import { HttpClientModule } from '@angular/common/http';

describe('JobService', () => {
  let service: JobService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule]
    });
    service = TestBed.inject(JobService);
  });

  fit('Frontend_day35_should_create_job_service', () => {
    expect(service).toBeTruthy();
  });
});
