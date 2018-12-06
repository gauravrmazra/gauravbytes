import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Router, NavigationStart } from '@angular/router';
import { AlertMessage } from '../_models/alert-message';
import { AlertMessageType } from '../_models/alert-message-type.enum';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  private subject = new Subject<AlertMessage>();
  private keepAfterNavigationChange = false;

  constructor(private router: Router) {
    // clear alert message on route change
    router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        if (this.keepAfterNavigationChange) {
          // only keep for a single location change
          this.keepAfterNavigationChange = false;
        } else {
          this.subject.next();
        }
      }
    });
  }

  success(message: string, keepAfterNavigationChange = false) {
    this.keepAfterNavigationChange = keepAfterNavigationChange;
    this.subject.next({ type: AlertMessageType.SUCCESS, message: message });
 }

  error(message: string, keepAfterNavigationChange = false) {
    this.keepAfterNavigationChange = keepAfterNavigationChange;
    this.subject.next({ type: AlertMessageType.ERROR, message: message });
  }

  getMessage(): Observable<AlertMessage> {
    return this.subject.asObservable();
  }
}
