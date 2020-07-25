import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PlaceOrderComponent } from './place-order/place-order.component'
import { CartComponent } from './cart/cart.component';
import { GetAllOrderdetailsComponent } from './get-all-orderdetails/get-all-orderdetails.component';
import { AppComponent } from './app.component';


const routes: Routes = [
  { path: 'placeOrder/:customerid', component: PlaceOrderComponent},
  { path: 'myOrders/:customerId', component: GetAllOrderdetailsComponent},
  { path: 'cart/:customerid', component: CartComponent},
  { path: 'home', component: AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [PlaceOrderComponent, CartComponent, GetAllOrderdetailsComponent]
