import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductsComponent } from './products/products.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductService } from './_services/product.service';
import { RouterModule, Routes } from '@angular/router';
import { ProductsRouting } from './products-routing.module';


const routes: Routes = [
  {
    path: '', component: ProductsComponent,
    children: [
      { path: '', component: ProductListComponent },
      { path: 'details/:id', component: ProductDetailsComponent}
    ]
  }
];
@NgModule({
  declarations: [ProductListComponent, ProductsComponent, ProductDetailsComponent],
  imports: [
    RouterModule,
    CommonModule,
    ProductsRouting
  ],
  exports: [],
  providers: [ProductService]
})
export class ProductsModule { }
