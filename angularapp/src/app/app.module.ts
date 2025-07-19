import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ErrorComponent } from './components/error/error.component';
import { JobListComponent } from './components/job-list/job-list.component';
import { AddJobComponent } from './components/add-job/add-job.component';
import { ViewApplicationComponent } from './components/view-application/view-application.component';
import { MyApplicationComponent } from './components/my-application/my-application.component';
import { ApplicationDetailsComponent } from './components/application-details/application-details.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { NavbarComponent } from './components/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ErrorComponent,
    JobListComponent,
    AddJobComponent,
    ViewApplicationComponent,
    MyApplicationComponent,
    ApplicationDetailsComponent,
    LoginComponent,
    RegisterComponent,
    NavbarComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
