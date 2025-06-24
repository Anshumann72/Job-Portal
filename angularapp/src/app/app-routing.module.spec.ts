import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppRoutingModule } from './app-routing.module';
import { Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('AppRoutingModule', () => {
  let router: Router;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        AppRoutingModule,
        RouterTestingModule.withRoutes([]),
        HttpClientModule, HttpClientTestingModule
      ]
    });

    router = TestBed.inject(Router);
    router.initialNavigation(); // Initialize the router
  });

  fit('Frontend_day34_should_navigate_to_add_job', async () => {
    await router.navigate(['add-job']);
    expect(router.url).toBe('/add-job');
  });

  fit('Frontend_day34_should_navigate_to_load_all_application', async () => {
    await router.navigate(['view-all-application']);
    expect(router.url).toBe('/view-all-application');
  });


});
