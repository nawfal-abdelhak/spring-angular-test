import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ArticleComponent } from './pages/article/article.component';
import { AddArticleComponent } from './pages/add-article/add-article.component';
import { OrdersComponent } from './pages/orders/orders.component';

const routes: Routes = [
  { path: '', component: ArticleComponent },
  { path: 'articles', component: ArticleComponent, },
  { path: 'articles/add', component: AddArticleComponent, },
  // children: [
  //   {
  //     path: '', component: ArticleComponent,
  //   },
  //   {
      
  //     path:'add', component: AddArticleComponent
  //   },
   
  // ] },

  { path: 'orders', component: OrdersComponent },

]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ]
})
export class AppRoutingModule { }

