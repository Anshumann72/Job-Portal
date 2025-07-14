import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ErrorComponent } from './components/error/error.component';
import { JobListComponent } from './components/job-list/job-list.component';
import { AddJobComponent } from './components/add-job/add-job.component';
import { ViewApplicationComponent } from './components/view-application/view-application.component';
import { ApplicationDetailsComponent } from './application-details/application-details.component';
import { MyApplicationComponent } from './my-application/my-application.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ErrorComponent,
    JobListComponent,
    AddJobComponent,
    ViewApplicationComponent,
    ApplicationDetailsComponent,
    MyApplicationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
