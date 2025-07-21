# deefdaafcac329136918cdfbcccefone
https://sonarcloud.io/summary/overall?id=iamneo-production_deefdaafcac329136918cdfbcccefone





services folder
=========================================

application.services.ts
-----------------



import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  public baseUrl = 'https://8080-aeecdbdbcb329136753cdfbcccefone.project.examly.io/api/applications';  // replace with your url

  constructor(private http: HttpClient) { }

  getAllApplications(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}`).pipe(catchError(this.handleError));
  }

  getApplicationById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`).pipe(catchError(this.handleError));
  }

  saveApplication(application: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, application).pipe(catchError(this.handleError));
  }

  getApplicationsByUserId(userId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/user/${userId}`).pipe(catchError(this.handleError));
  }

  updateApplication(id: number, application: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, application).pipe(catchError(this.handleError));
  }

  deleteApplication(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`).pipe(catchError(this.handleError));
  }

  private handleError(error: any) {
    return throwError(() => error);
  }
}


// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class ApplicationService {

//   constructor() { }
// }


auth.service.ts
------------------------



import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  baseUrl: string = 'https://8080-aeecdbdbcb329136753cdfbcccefone.project.examly.io/api/user';  // replace with your url

  private authStatus = new BehaviorSubject<boolean>(this.hasToken());
  private userRoleSubject = new BehaviorSubject<string | null>(localStorage.getItem('userRole'));
  private userIdSubject = new BehaviorSubject<number | null>(+localStorage.getItem('userId')!);

  constructor(private http: HttpClient) { }

  private hasToken(): boolean {
    return !!localStorage.getItem('token');
  }

  login(credentials: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/login`, credentials);
  }

  register(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, data);
  }

  logout(): void {
    localStorage.clear();
    this.authStatus.next(false);
    this.userRoleSubject.next(null);
    this.userIdSubject.next(null);
  }

  isAuthenticated(): boolean {
    return !!localStorage.getItem('token');
  }

  getAuthStatus(): Observable<boolean> {
    return this.authStatus.asObservable();
  }

  getUserId(): number | null {
    return this.userIdSubject.value;
  }

  getUserRole(): string | null {
    return this.userRoleSubject.value;
  }
}



// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class AuthService {

//   constructor() { }
// }


job.service.ts
----------------------------------

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class JobService {

  // public baseUrl = 'https://ide-dcdaebcc328808007cdfbcccefone.project.examly.io/proxy/8080/api/jobs';

   baseUrl = 'https://8080-aeecdbdbcb329136753cdfbcccefone.project.examly.io/api/jobs';  // replace with your url
   

   
  //  baseUrl = "http://localhost:8080/api/jobs";  

  constructor(private http: HttpClient) { }

  getAllJobs(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}`).pipe(catchError(this.handleError));
  }

  getJobById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`).pipe(catchError(this.handleError));
  }

  getJobsByUserId(userId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/user/${userId}`).pipe(catchError(this.handleError));
  }

  createJob(job: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, job).pipe(catchError(this.handleError));
  }

  updateJob(id: number, job: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, job).pipe(catchError(this.handleError));
  }

  deleteJob(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`).pipe(catchError(this.handleError));
  }

  private handleError(error: any) {
    return throwError(() => error);
  }
}


// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class JobService {

//   constructor() { }
// }

