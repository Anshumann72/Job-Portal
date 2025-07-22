import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddJobComponent } from './components/add-job/add-job.component';
import { JobListComponent } from './components/job-list/job-list.component';
import { ViewApplicationComponent } from './components/view-application/view-application.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { MyApplicationComponent } from './components/my-application/my-application.component';
import { ApplicationDetailsComponent } from './components/application-details/application-details.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { JobApplicationsComponent } from './components/job-applications/job-applications.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'job-list', component:JobListComponent},
  {path:'add-job',component:AddJobComponent},
  {path:'view-all-application', component:ViewApplicationComponent},
  {path:'login', component:LoginComponent},
  {path:'my-application', component:MyApplicationComponent},
  {path:'application-details',component:ApplicationDetailsComponent},
  {path:'add-job/:id', component:AddJobComponent},
  {path:'home', component:HomeComponent},
  {path:'application-details/:id', component:ApplicationDetailsComponent},
  {path:'navbar', component:NavbarComponent},
  {path:'job-application/:id', component:JobApplicationsComponent},
  {path:'register', component:RegisterComponent, pathMatch:'full'}
  //, {path:'**', redirectTo:'/login'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
