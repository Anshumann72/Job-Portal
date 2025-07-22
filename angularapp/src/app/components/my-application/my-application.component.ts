
import { Component, OnInit } from '@angular/core';

import { JobService } from 'src/app/services/job.service';
import { ApplicationService } from 'src/app/services/application.service';


@Component({
  selector: 'app-my-application',
  templateUrl: './my-application.component.html',
  styleUrls: ['./my-application.component.css']
})
export class MyApplicationComponent implements OnInit {

  jobs: any[] = [];
  // applicaions : any[] = [];
  errorMessage: string = '';
  currentUserId: number | null = null;

  results : any[] = [];

  constructor(private jobService : JobService, private appService : ApplicationService) { }

  ngOnInit(): void {
    this.currentUserId= +localStorage.getItem('userId');
    // this.fetchApplicationsByUserId(this.currentUserId);
    this.fetchJobsByUserId(this.currentUserId);
    
  }

  fetchJobsByUserId(currentUserId:number) {
    this.jobService.getAllJobs().subscribe((result)=>{
      let sourceData = result;
      // this.jobs = result;
      for(let job of sourceData) {
        let applications = job.applications;
        console.log(applications);
        
        for(let app of applications) {
         
          if(app.user.userId === currentUserId) {
            this.results.push({...app, jobTitle : job.title});
          }
        }
      }
    });
  }
}