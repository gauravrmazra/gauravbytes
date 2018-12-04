import { Component, OnInit } from '@angular/core';
import { LoginResponse } from '../_models/login-response';
import { LoginService } from '../_services/login.service';
import { LoginStatus } from '../_models/login-status.enum';
import { Router } from '@angular/router';
import { User } from '../_models/user';

@Component({
  selector: 'gb-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  private currentUser: User;

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit() {
    this.loginService.currentUserAsObservable.subscribe(user => {
      this.currentUser = user;
      if (this.currentUser == null || this.currentUser.status === LoginStatus.FAILURE) {
        this.router.navigate(['/login']);
      }
    });
  }

  logout() {
    this.loginService.logout();
    this.router.navigate(['/login']);
  }
}
