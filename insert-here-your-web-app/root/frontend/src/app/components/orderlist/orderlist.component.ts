import { Component, OnInit } from '@angular/core';
import {BookService} from "../booklist/book.service";
import {OrderService} from "./order.service";
import {formatDate} from "@angular/common";

@Component({
  selector: 'app-orderlist',
  templateUrl: './orderlist.component.html',
  styleUrls: ['./orderlist.component.css']
})
export class OrderlistComponent implements OnInit {

  constructor(private orderService: OrderService) { }

  // @ts-ignore
  orders: any[];

  ngOnInit(): void {
    this.updateOrders();
  }
  updateOrders(){
    this.orderService.getOrders().subscribe(resp=>{
      this.orders = resp.books;
      this.updateDates();
    })
  }

  updateDates(){
    this.orders.forEach(order =>{
      console.log(order);
      order.date = formatDate(order.date,"dd/MM/YYYY, h:mm", "en-US")
    })
  }

/*  getAdditionalInfo(){
    this.orderService.getOrderDetails().subscribe(resp=>{

    })
  }*/

}
