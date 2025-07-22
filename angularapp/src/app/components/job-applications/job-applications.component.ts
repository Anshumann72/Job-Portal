
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ApplicationService } from 'src/app/services/application.service';

@Component({
  selector: 'app-job-applications',
  templateUrl: './job-applications.component.html',
  styleUrls: ['./job-applications.component.css']
})
export class JobApplicationComponent implements OnInit {

  applicationForm : FormGroup;

  jobId: number = null;
 
  successMessage = "";
  errormessage = "";

  constructor(private router:ActivatedRoute, private applicationService:ApplicationService ,private rt:Router, private fb : FormBuilder) { }

  ngOnInit(): void {
    this.jobId = +this.router.snapshot.paramMap.get('id');
    this.applicationForm = this.fb.group({
      yearsOfExperience : [null],
      skills : [''],
      locationPreference : ['']
    });
  }

  submitApplication(){
  
    this.applicationService.saveApplication(this.applicationForm.value).subscribe((result)=>{
      alert('applied successfully');
      this.rt.navigate(['/my-application']);
    },
    (error)=>{
      console.log(error);
      
    })
  }

  

}