import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Book} from "../../model/book.model";

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getBooks(){
    return this.http.get<any>('http://localhost:8081/books/');
  }

}
