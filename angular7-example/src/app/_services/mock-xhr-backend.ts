import { HttpEvent, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Observer } from 'rxjs';
import { HttpBackend } from '@angular/common/http/src/backend';
import { LoginResponse } from '../_models/login-response';
import { LoginRequest } from '../_models/login-request';

export class MockXHRBackend implements HttpBackend {
  logins: Array<LoginRequest> = [
    { username: 'gaurav', password: 'x' },
    { username: 'pardeep', password: 'x'},
    { username: 'mary', password: 'x'}
  ];

  handle(request: HttpRequest<any>): Observable<HttpEvent<any>> {
    return new Observable((responseObserver: Observer<HttpResponse<any>>) => {
      let responseOptions;
      switch (request.method) {
        case 'GET':
          if (request.urlWithParams.indexOf('mediaitems?medium=') >= 0 || request.url === 'mediaitems') { }
          break;
        case 'POST':
          if (request.url === 'login') {
            // TODO login
            const requestUser: LoginRequest = request.body;
            const authenticatedUser = this.logins.filter(login => login.username === requestUser.username.toLowerCase() 
            && login.password === requestUser.password );

            if (authenticatedUser != null && authenticatedUser.length === 1) {
              responseOptions = {
                status: 200,
                body: { token: 'as', username: authenticatedUser[0].username }
              };
            } else {
              // TODO WIP
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
    return Math.random().toString(36);
  }
}
