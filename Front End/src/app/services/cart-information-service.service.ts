import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CartInformation } from '../model/cart-information';
import { CartConstants } from '../model/cart-constants';

@Injectable({
  providedIn: 'root'
})
export class CartInformationServiceService {

  constructor(private http: HttpClient) { }
  
  viewCartByCustomerId(customerid:number): Observable<any> {
    return this.http.get('http://localhost:8082/bookstore/viewcartbycustomerid/'+customerid);
  }

  public updateCart(cartId: number, quantity: number): Observable<any>{
    return this.http.put('http://localhost:8082/bookstore/update/'+cartId+'/'+quantity, cartId);
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

  bookList():Observable<any> {
    return this.http.get(CartConstants.VIEW_BOOKS_URL)
  }

  addBookToCart(bookId: number, customerId: number, status: string): Observable<any> {
    return this.http.post(CartConstants.ADD_BOOK_CART_URL + "/" + bookId + "/" + customerId + "/" + status, bookId);
  }
}
