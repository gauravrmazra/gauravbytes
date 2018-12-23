import { HttpEvent, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Observer } from 'rxjs';
import { HttpBackend } from '@angular/common/http/src/backend';
import { LoginRequest } from '../_models/login-request';
import { User } from '../_models/user';
import { LoginStatus } from '../_models/login-status.enum';
import { Product } from '../products/_model/product';

export class MockXHRBackend implements HttpBackend {
  logins: Array<LoginRequest> = [
    { username: 'gaurav', password: 'x' },
    { username: 'pardeep', password: 'x'},
    { username: 'mary', password: 'x'}
  ];

  login_users: Array<User> = [];

  _products: Array<Product> = [
    {
      id: 1,
      name: 'Apple IPhone',
      description: 'IPhone 8 plus'
    },
    {
      id: 2,
      name: 'Motorola',
      description: 'G4 plus mobile'
    },
    {
      id: 3,
      name: 'Nokia 3310',
      description: 'Old is gold'
    },
    {
      id: 4,
      name: 'XIOMI',
      description: 'Better camera quality'
    },
    {
      id: 5,
      name: 'Microsoft surface',
      description: 'Light notebook'
    }
  ];

  handleNotImplemented(request: HttpRequest<any>): any {
    return { status: 500, body: `Not implemented ${request.url}` };
  }

  handlePost(request: HttpRequest<any>): any {
    if (request.url === '/login') {
     return this.handlePostForLogin(request);
    } else {
      return this.handleNotImplemented(request);
    }
  }

  handlePostForLogin(request: HttpRequest<any>): any {
    let responseOptions;
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
    return responseOptions;
  }

  handleGet(request: HttpRequest<any>): any {
    if (request.url.startsWith('/products')) {
      return this.handleGetForProduct(request);
    } else {
      return this.handleNotImplemented(request);
    }
  }

  handleGetForProduct(request: HttpRequest<any>): any {
    if (request.url === '/products') {
      return {
        status: 200,
        body: this._products
      };
    } else {
      const id: number = parseInt(request.url.split('/')[2], 10);
      const matchedProducts: Array<Product> = this._products.filter(product => product.id === id);
      if (matchedProducts.length === 1) {
        return {
          status: 200,
          body: matchedProducts[0]
        };
      } else {
        const status = matchedProducts.length === 0 ? 400 : 500;
        const body = matchedProducts.length === 0 ? 'No product found' : 'Too many products';
        return { status, body };
      }
    }
  }

  handle(request: HttpRequest<any>): Observable<HttpEvent<any>> {
    return new Observable((responseObserver: Observer<HttpResponse<any>>) => {
      let responseOptions;
      switch (request.method) {
        case 'GET':
          responseOptions = this.handleGet(request);
          break;
        case 'POST':
          responseOptions = this.handlePost(request);
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
