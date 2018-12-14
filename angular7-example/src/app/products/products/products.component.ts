import { Component, OnInit } from '@angular/core';
import { ProductService } from '../_services/product.service';
import { Product } from '../_model/product';

@Component({
  selector: 'gb-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  products: Array<Product>;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.getProducts().subscribe((products: Array<Product>) => this.products = products, error => {
      console.log(error);
    });
  }

}
