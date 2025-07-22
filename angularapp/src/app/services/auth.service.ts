
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  baseUrl: string = 'https://8080-deefdaafcac329136918cdfbcccefone.project.examly.io/api/user';

  private authStatus = new BehaviorSubject<boolean>(this.hasToken());
  private userRoleSubject = new BehaviorSubject<string | null>(localStorage.getItem('userRole'));
  private userIdSubject = new BehaviorSubject<number | null>(+localStorage.getItem('userId')!);

  constructor(private http: HttpClient) {}

  private hasToken(): boolean {
    return !!localStorage.getItem('token');
  }

  login(credentials: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/login`, credentials);
  }

  // ✅ Accepts only username, password, and role
  register(data: { username: string; password: string; role: string }): Observable<any> {
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
