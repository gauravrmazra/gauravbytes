import { Component, OnInit, Input, Output } from '@angular/core';
import { LoginResponse } from '../_models/login-response';
import { EventEmitter } from 'events';
import { User } from '../_models/user';

@Component({
  selector: 'gb-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent implements OnInit {
  @Input() user: User;

  @Output() logoutEvent = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  logout() {
    this.logoutEvent.emit(this.user.token);
  }

}
