import { Component, OnInit } from '@angular/core';
import { Product } from '../_model/product';
import { ProductService } from '../_services/product.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'gb-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss']
})
export class ProductDetailsComponent implements OnInit {

  product: Product;

  constructor(private routes: ActivatedRoute, private productService: ProductService) { }

  ngOnInit() {
    this.routes.params.subscribe(parameters => {
      const id: number = parameters['id'];
      this.productService.getProduct(id).subscribe(product => this.product = product, error => console.log(error));
    });
  }

}
