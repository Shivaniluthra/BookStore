import { Component, OnInit } from '@angular/core';
import { OrderInformationServiceService } from '../services/order-information-service.service';
import { OrderInformation } from '../model/order-information';
import { ActivatedRoute } from '@angular/router';
import { CartInformation } from '../model/cart-information';
import { CartInformationServiceService } from '../services/cart-information-service.service';

@Component({
  selector: 'app-get-all-orderdetails',
  templateUrl: './get-all-orderdetails.component.html',
  styleUrls: ['./get-all-orderdetails.component.css']
})
export class GetAllOrderdetailsComponent implements OnInit {
  customerId : number;
  details: boolean= false;
  cartProducts: CartInformation[]=[];
  i:number=0; quantity:number=0; total: number=0;

  constructor(private service: OrderInformationServiceService, private route: ActivatedRoute, private cartService: CartInformationServiceService) { }
  orderList:Array<OrderInformation> ;
  order:OrderInformation=new OrderInformation();
  ngOnInit(): void {
    this.customerId = this.route.snapshot.params['customerId'];
    this.viewOrderByCustomerId();
  }
  viewOrderByCustomerId(){
	this.service.viewOrderByCustomerId(this.customerId).subscribe(
      	(order)=>{this.orderList= order;},
      	(error)=>{alert("Please Enter Valid Customer ID");}); 
  }
	
  viewOrderById(orderId:number){
    this.details=true;
    this.service.viewOrderById(orderId).subscribe(
      (getOrder)=>{this.order= getOrder;},
      (error)=>{alert("Please Enter Valid order ID");});
      this.getCartDetails();
  }

  getCartDetails(){
    this.cartService.viewCartByCustomerId(this.customerId)
    .subscribe(data=>{
      this.cartProducts=data;
      console.log(this.cartProducts);
      this.order.cart=this.cartProducts;
      while(this.i<this.cartProducts.length){
        this.quantity= this.quantity+ this.cartProducts[this.i].quantity;
        this.total= this.total+ this.cartProducts[this.i].subTotal;
        this.i++;
      }
    });
  }
}

