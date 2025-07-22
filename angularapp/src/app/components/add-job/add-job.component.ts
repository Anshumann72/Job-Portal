
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Job } from 'src/app/models/job.model';
import { JobService } from 'src/app/services/job.service';

@Component({
  selector: 'app-add-job',
  templateUrl: './add-job.component.html',
  styleUrls: ['./add-job.component.css']
})
export class AddJobComponent implements OnInit {

  job: Job = {
    jobId: 0,
    title: '',
    description: '',
    company: '',
    location: ''
  };
  successMessage = '';
  errorMessage = '';
  isEditMode = false;

  constructor(
    private route: ActivatedRoute,
    private jobService: JobService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const jobId = Number(this.route.snapshot.paramMap.get('id'));
    if (jobId) {
      this.isEditMode = true;
      this.loadJobDetails(jobId);
    }
  }

  loadJobDetails(id: number): void {
    this.jobService.getJobById(id).subscribe({
      next: (data) => this.job = data,
      error: () => this.errorMessage = 'Error loading job details'
    });
  }

  saveJob(): void {
    if (this.isEditMode) {
      this.jobService.updateJob(this.job.jobId,this.job).subscribe({
        next: () => {
          this.successMessage = 'Job updated successfully';
          this.router.navigate(['/job-list']);
        },
        error: () => this.errorMessage = 'Failed to update job'
      });
    } else {
      this.jobService.createJob(this.job).subscribe({
        next: () => {
          this.successMessage = 'Job added successfully';
          console.log("**************************")
          this.clearForm();
        },
        error: () => this.errorMessage = 'Failed to add job'
      });
    }
  }

  clearForm(): void {
    this.job = { jobId: 0, title: '', description: '', company: '', location: '' };
  }
}
