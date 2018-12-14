import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import { AppRoutingModule } from '../app-routing.module';
import { ProductsComponent } from './products/products.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductService } from './_services/product.service';

@NgModule({
  declarations: [ProductListComponent, ProductsComponent, ProductDetailsComponent],
  imports: [
    CommonModule,
    AppRoutingModule
  ], providers: [ProductService]
})
export class ProductsModule { }
