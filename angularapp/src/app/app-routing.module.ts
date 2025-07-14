import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddJobComponent } from './components/add-job/add-job.component';
import { JobListComponent } from './components/job-list/job-list.component';
import { ViewApplicationComponent } from './components/view-application/view-application.component';

const routes: Routes = [
  {path:'add-job',component:AddJobComponent},
  {path:'job-list', component:JobListComponent},
  {path:'view-all-application',component:ViewApplicationComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
