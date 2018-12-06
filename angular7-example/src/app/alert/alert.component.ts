import { Component, OnInit, OnDestroy } from '@angular/core';
import { AlertMessage } from '../_models/alert-message';
import { AlertMessageType } from '../_models/alert-message-type.enum';
import { AlertService } from '../_services/alert.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'gb-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.scss']
})
export class AlertComponent implements OnInit, OnDestroy {
  alertMessageType = AlertMessageType;

  private subscription: Subscription;
  message: AlertMessage;

  constructor(private alertService: AlertService) { }

  ngOnInit() {
    this.subscription = this.alertService.getMessage().subscribe(message => this.message = message);
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
