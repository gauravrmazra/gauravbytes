import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductsComponent } from './products/products.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductService } from './_services/product.service';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [ProductListComponent, ProductsComponent, ProductDetailsComponent],
  imports: [
    RouterModule,
    CommonModule
  ], providers: [ProductService]
})
export class ProductsModule { }
