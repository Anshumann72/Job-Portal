
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: any = {};
  successMessage = '';
  errorMessage = '';
  showModal = false;

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {}

  register(form: NgForm) {
    if (
      form.invalid ||
      !this.user.username ||
      !this.user.password ||
      !this.user.confirmPassword ||
      this.user.password !== this.user.confirmPassword ||
      !this.user.role
    ) {
      this.errorMessage = this.getErrorMsg();
      return;
    }

    // ✅ Send only required fields to backend
    const payload = {
      username: this.user.username,
      password: this.user.password,
      role: this.user.role
    };

    this.authService.register(payload).subscribe({
      next: () => {
        this.successMessage = "Registration successful!";
        this.showModal = true;
      },
      error: err => {
        this.errorMessage = err.error?.message || "Registration failed.";
      }
    });
  }

  getErrorMsg(): string {
    if (!this.user.username) return "Username is required";
    if (!this.user.password) return "Password is required";
    if (!this.user.confirmPassword) return "Confirm password is required";
    if (this.user.password !== this.user.confirmPassword) return "Passwords do not match";
    if (!this.user.role) return "Role is required";
    return '';
  }

  redirectToLogin() {
    this.router.navigate(['/login']);
  }
}
