import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderInformation } from '../model/order-information';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderInformationServiceService {
 private uri : string = '';

  constructor(private http : HttpClient) { }

  addOrder(order: OrderInformation): Observable<Object> {
    return this.http.post('http://localhost:8082/bookstore/addOrder',order);
  }
  viewOrderByCustomerId(customerId:number):Observable<any>{
    return this.http.get("http://localhost:8082/bookstore/viewOrderByCustomerId/"+customerId);
  }
  viewOrderById(orderId:number): Observable<any>{
    return this.http.get("http://localhost:8082/bookstore/searchOrder/"+orderId);
  }
  
}
