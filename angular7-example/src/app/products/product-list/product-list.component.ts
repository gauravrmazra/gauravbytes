import { Component, OnInit, Input } from '@angular/core';
import { Product } from '../_model/product';

@Component({
  selector: 'gb-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  @Input() products: Array<Product>;

  constructor() { }

  ngOnInit() {
  }

}
