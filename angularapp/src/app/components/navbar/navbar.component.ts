
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedin = false;
  userName: string | null = '';
  userRole: string | null = '';
  showLogoutPopup = false;

  constructor(private router: Router) { }

  ngOnInit(): void {
    const token = localStorage.getItem('token');
    this.isLoggedin = !!token;

    this.userName = localStorage.getItem('username'); // <-- key must be correct
    this.userRole = localStorage.getItem('userRole');
  }

  confirmLogout() {
    this.showLogoutPopup = true;
  }

  logout() {
    localStorage.clear();
    this.showLogoutPopup = false;
    this.isLoggedin = false;
    this.router.navigate(['/login']);
  }

  cancelLogout() {
    this.showLogoutPopup = false;
  }
}

