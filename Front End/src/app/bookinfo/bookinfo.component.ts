import { Component, OnInit } from '@angular/core';
import { CartInformationServiceService } from '../services/cart-information-service.service';

@Component({
  selector: 'app-bookinfo',
  templateUrl: './bookinfo.component.html',
  styleUrls: ['./bookinfo.component.css']
})
export class BookinfoComponent implements OnInit {
  newFlag = false;
  viewBookFlag = false;
  status = "cart";
  customerId = 0;
  books: any = [];
  book: BookinfoComponent[];
  errorMsg: string;
  constructor(private cartService: CartInformationServiceService) { }

  ngOnInit() {
  }

  viewBook() {
    this.cartService.bookList().subscribe(data => {

      this.books = data;
      this.viewBookFlag = true;
    })
    this.newFlag = true;

  }
  addBookToCart(bookId: number) {
    this.cartService.addBookToCart(bookId, this.customerId, this.status).subscribe(data => {
      console.log(data);
    }, error => this.errorMsg = error.error.message)
    alert("Book Added to Cart Successfully");
  }

}
