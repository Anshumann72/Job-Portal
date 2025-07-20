import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-job',
  templateUrl: './add-job.component.html',
  styleUrls: ['./add-job.component.css']
})
export class AddJobComponent implements OnInit {
  job: any = {};
  successMessage: string = '';
  errorMessage: string = '';
  isEditMode: boolean = false;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    const jobId = this.route.snapshot.paramMap.get('id');
    if (jobId) {
      this.isEditMode = true;
      this.loadJobDetails(+jobId);
    }
  }

  loadJobDetails(jobId: number): void {
    // Placeholder for job loading logic
    console.log('Loading job details for ID:', jobId);
  }

  saveJob(): void {
    if (this.isEditMode) {
      this.successMessage = 'Job updated successfully!';
    } else {
      this.successMessage = 'Job added successfully!';
      this.clearForm();
    }
  }

  clearForm(): void {
    this.job = {};
  }

}
