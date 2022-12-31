import { Component } from '@angular/core';
import { OrderService } from './services/order.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';

  constructor(public orderService:OrderService) { }

  ngOnInit(): void {
    this.getOrders()
  }


  getOrders() {
    this.orderService.getOrders().then((data: any) => {
      this.orderService.orders$.next(data)
    }).catch()
  }
}


