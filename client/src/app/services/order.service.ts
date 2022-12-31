import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Order } from '../models/order';
import { BehaviorSubject } from 'rxjs/internal/BehaviorSubject';
@Injectable({
  providedIn: 'root'
})
export class OrderService {
  URL = `orders`;
  orders$ = new BehaviorSubject<Order[]>([]);
  constructor(private api: ApiService) { }

  getOrders() {
    return this.api.get("orders");
  }

  addOrder(articles: any) {
    let headers = this.api.getHeaders();

    return this.api.post(this.URL, articles, { headers });
  }

  updateOrder(articles: any, id: number) {
    let headers = this.api.getHeaders();

    return this.api.put(`${this.URL}/${id}`, articles, { headers });
  }
}
