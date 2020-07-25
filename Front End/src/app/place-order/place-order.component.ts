import { Component, OnInit } from '@angular/core';
import { OrderInformation } from '../model/order-information';
import { OrderInformationServiceService } from '../services/order-information-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CartInformationServiceService } from '../services/cart-information-service.service';
import { Observable } from 'rxjs';
import { CartInformation } from '../model/cart-information';
import { CustomerInformation } from '../model/customer-information';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {
  order : OrderInformation;
  products: Observable<CustomerInformation[]>;
  cartProducts:CartInformation[]=[];
  customerid: number;
  i:number=0; quantity:number=0; total: number=0;
  customer: CustomerInformation;

  constructor(private orderService: OrderInformationServiceService, private router : Router, 
    private route: ActivatedRoute, private cartService: CartInformationServiceService) { }

  ngOnInit(): void {
    this.customerid = this.route.snapshot.params['customerid'];
    console.log(this.customerid);
    this.getCartDetails();
    this.customer = new CustomerInformation();
    this.customer.customerId = this.customerid;
    this.order=new OrderInformation();
    this.order.customer= this.customer;
    this.order.orderDate = new Date();
    this.order.orderStatus= "Placed";
    this.order.paymentMethod = "Cash On Delivery";
    
  }

  getCartDetails(){
    this.cartService.viewCartByCustomerId(this.customerid)
    .subscribe(data=>{
      this.cartProducts=data;
      console.log(this.cartProducts);
      this.order.cart=this.cartProducts;
      while(this.i<this.cartProducts.length){
        this.quantity= this.quantity+ this.cartProducts[this.i].quantity;
        this.total= this.total+ this.cartProducts[this.i].subTotal;
        this.i++;
      }
      this.order.totalPrice= this.total;
      this.order.quantity= this.quantity;
    });
  }

  save(){
    this.orderService.addOrder(this.order)
    .subscribe(data=> console.log(data), error => console.log(error));
    this.order= new OrderInformation();
    this.goTo();
  }

  onSubmit() : void {
    console.log(this.order);
    this.save();
    alert("Order Placed Successfully!");
  }

  goTo(){
    this.router.navigate(['']);
  }

  edit(){
    this.router.navigate(['cart/'+this.customerid]);
  }
}
