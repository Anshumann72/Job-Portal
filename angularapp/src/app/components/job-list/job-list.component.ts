import { Component, OnInit } from '@angular/core';
import { Job } from 'src/app/models/job.model';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.css']
})
export class JobListComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  jobs:Job[]=[]

  updateJob(id:number){

  }

  deleteJob(id:number){
    
  }

}
