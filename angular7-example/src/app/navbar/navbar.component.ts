import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { User } from '../_models/user';

@Component({
  selector: 'gb-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent implements OnInit {
  @Output() logout = new EventEmitter<User>(true);
  @Input() user: User;

  constructor() { }

  ngOnInit() {
  }

  onLogout() {
    this.logout.emit(this.user);
  }
}
