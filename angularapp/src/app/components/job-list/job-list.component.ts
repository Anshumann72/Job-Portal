
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobService } from 'src/app/services/job.service';
// import { Job } from 'src/app/models/job.model';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.css']
})


export class JobListComponent implements OnInit {

  jobs: any[] = [];
  errorMessage: string = '';

  role : string = '';

  constructor(private router: Router,private jobService:JobService) { }

  ngOnInit(): void {
    this.role = localStorage.getItem('userRole');
    this.loadJobs();
  }

  loadJobs(): void {
    try {
      // Use service later; for now mock data
      this.jobService.getAllJobs().subscribe((data)=>{
        this.jobs=data;
        console.log(data);
      });
      
    } catch (error) {
      this.errorMessage = 'Failed to load jobs.';
    }
  }

  updateJob(id: number): void {
    this.router.navigate(['/add-job', id]); // Navigates with job ID as param
  }



  deleteJob(id: number): void {
    // You’ll replace this with JobService.deleteJob(id) later
    // this.jobs = this.jobs.filter(job => job.id !== id);
    this.jobService.deleteJob(id).subscribe(()=>{
      console.log("*****************************************")
      this.loadJobs();
    });
    
    console.log(`Job with ID ${id} deleted.`);
  }

  // viewJobApplications(id: number): void {
  //   this.router.navigate(['/application-details', id]);
  // }

  applyForJob(jobId : number) {
    console.log(jobId);
    
    this.router.navigate(['/job-application',jobId]);
  }
}