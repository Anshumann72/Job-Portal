

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  public baseUrl = 'https://8080-deefdaafcac329136918cdfbcccefone.project.examly.io/api/applications';  //'http://localhost:8080/api/applications';

  constructor(private http: HttpClient) { }

  getAllApplications(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}`).pipe(catchError(this.handleError));
  }

  getApplicationById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`).pipe(catchError(this.handleError));
  }

  saveApplication(application:any, jobId: number): Observable<any> {
    const userId = localStorage.getItem('userId');
    return this.http.post(`${this.baseUrl}/${jobId}/${userId}`, application).pipe(catchError(this.handleError));
  }

  getApplicationsByUserId(userId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/user/${userId}`).pipe(catchError(this.handleError));
  }

  updateApplication(id: number, application: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/status/${id}`, application).pipe(catchError(this.handleError));
  }

  deleteApplication(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`).pipe(catchError(this.handleError));
  }

  private handleError(error: any) {
    return throwError(() => error);
  }
}

