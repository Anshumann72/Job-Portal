import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApplicationService } from 'src/app/services/application.service';
// import { Application } from 'src/app/models/application.model';
// import { Job } from 'src/app/models/job.model';
import { JobService } from 'src/app/services/job.service';

@Component({
  selector: 'app-application-details',
  templateUrl: './application-details.component.html',
  styleUrls: ['./application-details.component.css']
})


export class ApplicationDetailsComponent implements OnInit {

  jobId: number=null;
  errorMessage = '';
  jobDetails: any;

  

  selectedApplication : any = null;
  

  constructor(private route: ActivatedRoute,private jobService:JobService, private appService : ApplicationService) { }

  ngOnInit(): void {
    this.jobId = +this.route.snapshot.paramMap.get('id');
    console.log(this.jobId);
    
    
     this.fetchJobById();
  }

  fetchJobById(): void {

    this.jobService.getJobById(this.jobId).subscribe((data)=>{
      
      this.jobDetails = data;
      console.log(this.jobDetails.title);
      // this.selectedApplications = this.jobDetails.applicaions;
    });

  }

  

  updateApplicationStatus(applicationId: number, newStatus: string): void {
    this.appService.getApplicationById(applicationId).subscribe((data)=>{
      this.selectedApplication = data;
      this.selectedApplication.status = newStatus;
      this.appService.updateApplication(applicationId, this.selectedApplication).subscribe((data)=>{
        alert("Status updated successfully.");
      });
    });
  }
}
