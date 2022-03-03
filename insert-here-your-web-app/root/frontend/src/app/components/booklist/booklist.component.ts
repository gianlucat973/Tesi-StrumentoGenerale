import {Component, OnInit} from '@angular/core';
import {BookService} from "./book.service";
import {Book} from "../../model/book.model";
import {OrderService} from "../orderlist/order.service";
import {AuthService} from "../auth/auth.service";

@Component({
  selector: 'app-booklist', templateUrl: './booklist.component.html', styleUrls: ['./booklist.component.css']
})
export class BooklistComponent implements OnInit {

  // @ts-ignore
  books: any[];

  constructor(private bookService: BookService, private orderService: OrderService, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.updateBooks();
  }

  clickMethod(book: Book) {
    if (book.quantity > 0) {
      if (confirm("Are you sure to buy " + book.title)) {
        this.orderService.makeOrder(this.authService.user.getValue().getEmail(), this.authService.user.getValue().getToken(), book.isbn, 1).subscribe(response => {
          this.updateBooks();
        });
      }
    } else {

    }
  }

  updateBooks() {
    this.bookService.getBooks().subscribe(resp => {
      this.books = resp;
    })
  }
}
