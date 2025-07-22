
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class JobService {

  // public baseUrl = 'https://ide-dcdaebcc328808007cdfbcccefone.project.examly.io/proxy/8080/api/jobs';

   baseUrl = 'https://8080-deefdaafcac329136918cdfbcccefone.project.examly.io/api/jobs';  // replace with your url
   

   
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

