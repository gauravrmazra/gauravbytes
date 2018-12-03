import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { BehaviorSubject, Observable } from 'rxjs';
import { LoginRequest } from '../_models/login-request';
import { LoginResponse } from '../_models/login-response';
import { LoginStatus } from '../_models/login-status.enum';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private userSubject: BehaviorSubject<LoginResponse>;
  private user: Observable<LoginResponse>;


  constructor(private http: HttpClient) {
    this.userSubject = new BehaviorSubject<LoginResponse>({ token: null, status: LoginStatus.FAILURE });
    this.user = this.userSubject.asObservable();
  }

  get currentUserAsObservable() {
    return this.userSubject;
  }

  get currentUser() {
      return this.userSubject.value;
  }

  login(loginRequest: LoginRequest) {
    return this.http.post(`/login`, loginRequest)
        .pipe(map((response: LoginResponse) => {
            const status: LoginStatus | undefined = (<any>LoginStatus)[response.status.toString()];
            const result: LoginResponse = { status: status, token: response.token };
            if (result && result.status === LoginStatus.SUCCESS) {
                this.userSubject.next(result);
            }
            return result;
        }));
  }
}
