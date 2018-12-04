import { HttpEvent, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Observer } from 'rxjs';
import { HttpBackend } from '@angular/common/http/src/backend';
import { LoginResponse } from '../_models/login-response';
import { LoginRequest } from '../_models/login-request';
import { User } from '../_models/user';
import { LoginStatus } from '../_models/login-status.enum';

export class MockXHRBackend implements HttpBackend {
  logins: Array<LoginRequest> = [
    { username: 'gaurav', password: 'x' },
    { username: 'pardeep', password: 'x'},
    { username: 'mary', password: 'x'}
  ];

  login_users: Array<User> = [];

  handle(request: HttpRequest<any>): Observable<HttpEvent<any>> {
    return new Observable((responseObserver: Observer<HttpResponse<any>>) => {
      let responseOptions;
      switch (request.method) {
        case 'GET':
          if (request.urlWithParams.indexOf('mediaitems?medium=') >= 0 || request.url === 'mediaitems') { }
          break;
        case 'POST':
          if (request.url === '/login') {
            // TODO login
            const requestUser: LoginRequest = request.body;
            const authenticatedUser = this.logins.filter(login => login.username === requestUser.username.toLowerCase() 
            && login.password === requestUser.password );

            if (authenticatedUser != null && authenticatedUser.length === 1) {
              responseOptions = {
                status: 200,
                body: { token: this._getNewToken(authenticatedUser[0].username), status: LoginStatus.SUCCESS }
              };
            } else {
              responseOptions = {
                status: 403,
                body: { token: null, status: LoginStatus.FAILURE }
              };
            }
          }
          break;
        case 'PUT':
        case 'DELETE':
          responseOptions = {status: 200};
          break;
      }

      const responseObject = new HttpResponse(responseOptions);
      responseObserver.next(responseObject);
      responseObserver.complete();
      return () => {
      };
    });
  }

  _deleteItem(id, items) {
    const itemToDelete = items.find(item => item.id === id);
    const index = items.indexOf(itemToDelete);
    if (index >= 0) {
      items.splice(index, 1);
    }
  }

  _getNewId(items) {
    if (items.length > 0) {
      return Math.max.apply(Math, items.map(mediaItem => mediaItem.id)) + 1;
    } else {
      return 1;
    }
  }

  _getNewToken(username: string): string {
    const token: string = Math.random().toString(36).substring(2, 15) + Math.random().toString(36).substring(2, 15);
    this.login_users.push({ token, username, status: LoginStatus.SUCCESS });
    return token;
  }
}
