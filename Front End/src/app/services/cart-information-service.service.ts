import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CartInformation } from '../model/cart-information';

@Injectable({
  providedIn: 'root'
})
export class CartInformationServiceService {

  constructor(private http: HttpClient) { }
  
  viewCartByCustomerId(customerid:number): Observable<any> {
    return this.http.get('http://localhost:8082/bookstore/viewcartbycustomerid/'+customerid);
  }

  public updateCart(updateForm: CartInformation):Observable<any>{
    return this.http.put('http://localhost:8082/bookstore/update',updateForm);
  }

  removecartItem(cartId : number) : Observable<any>
  {
    console.log("Id="+cartId);
    return this.http.delete('http://localhost:8082/bookstore/removecartitem'+cartId, { responseType: 'text' });
  }
  clearCartByCustomerId(customerId : number) : Observable<any>
  {
    return this.http.delete('http://localhost:8082/bookstore/clearcartbycustomerid'+customerId, { responseType: 'text' });
  }
}
