import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order';
import { ArticleService } from 'src/app/services/article.service';
import { HelpersService } from 'src/app/services/helpers.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  constructor(public orderService: OrderService, public helper: HelpersService, private articleService: ArticleService) { }

  ngOnInit(): void {
    this.getOrders()
  }

  show_articles: boolean = false;
  selectedOrder: any = null;

  getOrders() {
    this.orderService.getOrders().then((data: any) => {
      this.orderService.orders$.next(data)
    }).catch()
  }

  addOrder() {
    this.selectedOrder = null;
    this.show_articles = !this.show_articles;

  }

  EventHandler(event: any) {
    if (event.type == "add") {
      this.orderService.addOrder(event.articles).then((data: any) => {
        this.orderService.orders$.next([...this.orderService.orders$.getValue(), data])
        this.show_articles = !this.show_articles;
      }).catch()
    }

    else {
      this.show_articles = !this.show_articles;
      this.orderService.updateOrder(event.articles, this.selectedOrder.id).then((data: any) => {
        var orders = this.orderService.orders$.value;
        orders.forEach((element: Order) => {
          element.id == this.selectedOrder.id && (element.articles = data.articles)
        });
        this.orderService.orders$.next(orders)
      }).catch()
    }

  }

  editOrder(order: Order) {
    this.selectedOrder = order;
    this.show_articles = !this.show_articles;
  }

}
