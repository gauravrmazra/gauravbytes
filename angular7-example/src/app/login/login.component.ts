import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { LoginService } from '../_services/login.service';

import {first} from 'rxjs';
import { LoginResponse } from '../_models/login-response';
import { LoginStatus } from '../_models/login-status.enum';
import { Router } from '@angular/router';

@Component({
  selector: 'gb-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted = false;
  loading = false;

  constructor(private formBuilder: FormBuilder,
    private loginService: LoginService,
    private router: Router) {}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: this.formBuilder.control('', [Validators.required]),
      password: this.formBuilder.control('', [Validators.required])
    });
  }

  onLogin() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;

    const loginFormControls = this.loginForm.controls;
    const username = loginFormControls.username.value;
    const password = loginFormControls.password.value;

    this.loginService.login({ username, password })
    .pipe(first())
    .subscribe((data: LoginResponse) => {
      if (data.status === LoginStatus.SUCCESS) {
        this.router.navigate(['/home']);
      } else {
        this.loading = false;
        //this.alertService.error(`Login failed due to: ${data.status}`);
      }
    }, error => {
      this.loading = false;
      this.submitted = false;
      if (error.status === 403) {
        //this.alertService.error(`wrong username or password`);
      }
    });
  }

}
