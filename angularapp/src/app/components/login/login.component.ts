
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
    username: '',
    password: ''
  };
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {}

  onLogin(form: NgForm): void {
    if (form.invalid) return;

    const loginPayload = {
      username: this.user.username,
      password: this.user.password
    };

    this.authService.login(loginPayload).subscribe({
      next: (res) => {
        console.log('Login successful:', res);
               localStorage.setItem('userRole', res.role);
        localStorage.setItem('userId', res.id);
        localStorage.setItem('userName', this.user.username); // Using input username
        this.router.navigate(['/home']);
      },
      error: () => {
        this.errorMessage = 'Invalid username or password';
      }
    });
  }
}
