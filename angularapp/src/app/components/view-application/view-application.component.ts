
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApplicationService } from 'src/app/services/application.service';
import { JobService } from 'src/app/services/job.service';

@Component({
  selector: 'app-view-application',
  templateUrl: './view-application.component.html',
  styleUrls: ['./view-application.component.css']
})
export class ViewApplicationComponent implements OnInit {

  jobs : any[] = [];
  applications : any[] = [];

  errorMessage: string = '';

  results : any[] = [];

  constructor(private router: Router, private jobService : JobService, private appService : ApplicationService) { }

  ngOnInit(): void {
    this.fetchJobs();
    
  }

  

  viewJobDetails(jobId: number): void {
    console.log("view application jobId" + jobId);
    
    this.router.navigate(['/application-details', jobId]);
  }

  fetchJobs() {
    this.jobService.getAllJobs().subscribe((result)=>{
      this.jobs = result;
      
    });
  }

}

