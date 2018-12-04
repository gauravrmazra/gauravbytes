import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { BehaviorSubject, Observable } from 'rxjs';
import { LoginRequest } from '../_models/login-request';
import { LoginResponse } from '../_models/login-response';
import { LoginStatus } from '../_models/login-status.enum';
import { User } from '../_models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private userSubject: BehaviorSubject<User>;
  private user: Observable<User>;


  constructor(private http: HttpClient) {
    this.userSubject = new BehaviorSubject<User>({ token: null, username: null, status: LoginStatus.FAILURE });
    this.user = this.userSubject.asObservable();
  }

  get currentUserAsObservable(): Observable<User> {
    return this.user;
  }

  get currentUser() {
      return this.userSubject.value;
  }

  login(loginRequest: LoginRequest): Observable<LoginResponse> {
    return this.http.post(`/login`, loginRequest)
        .pipe(map((response: LoginResponse) => {
            const result: LoginResponse = { status: response.status, token: response.token };
            if (result && result.status === LoginStatus.SUCCESS) {
                this.userSubject.next({token: result.token, status: response.status, username: loginRequest.username });
            }
            return result;
        }));
  }

  logout() {
    this.http.post(`/logout`, this.currentUser).subscribe(response => {
      this.userSubject.next(null);
    });
  }
}
