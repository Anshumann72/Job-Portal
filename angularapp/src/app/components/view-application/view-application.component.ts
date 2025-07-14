import { Component, OnInit } from '@angular/core';
import { Job } from 'src/app/models/job.model';

@Component({
  selector: 'app-view-application',
  templateUrl: './view-application.component.html',
  styleUrls: ['./view-application.component.css']
})
export class ViewApplicationComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.fetchJobs();
  }

  jobs:Job[]=[]

  errorMessage:string

  fetchJobs(){
    
  }

  viewJobDetails(jobId:number){
    
  }



}
