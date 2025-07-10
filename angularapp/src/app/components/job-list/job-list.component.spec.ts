import { ComponentFixture, TestBed } from '@angular/core/testing';
import { JobListComponent } from './job-list.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

describe('JobListComponent', () => {
  let component: JobListComponent;
  let fixture: ComponentFixture<JobListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, 
        RouterTestingModule 
      ],  
      declarations: [ JobListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JobListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  fit('Frontend_day31_create_Job_List_Component with jobs array', () => {
    expect(component).toBeTruthy();
    expect((component as any).jobs).toBeDefined();
    expect(Array.isArray((component as any).jobs)).toBe(true);
  });

  fit('Frontend_day32_should have updateJob method', () => {
    expect((component as any).updateJob).toBeDefined();
    expect(typeof (component as any).updateJob).toBe('function');
  });

  fit('Frontend_day32_should have deleteJob method', () => {
    expect((component as any).deleteJob).toBeDefined();
    expect(typeof (component as any).deleteJob).toBe('function');
  });


});
