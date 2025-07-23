

import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: any = {
    email: '',
    password: ''
  };
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void { }

  onLogin(form: NgForm): void {
    if (form.invalid) return;
  
    const loginPayload = {
      username: this.user.username,
      password: this.user.password,
      role: this.user.role   // Make sure this field exists and is bound in your form
    };
  
    this.authService.login(loginPayload).subscribe({
      next: (res) => {

        console.log(res);
        localStorage.setItem('token', res.token);
        localStorage.setItem('userRole', res.role);
        localStorage.setItem('userId', res.id);
        localStorage.setItem('userName', res.username); // If needed
        this.router.navigate(['/home']);
      },
      error: () => {
        this.errorMessage = 'Invalid username or password';
      }
    });
  }
  
  
}

