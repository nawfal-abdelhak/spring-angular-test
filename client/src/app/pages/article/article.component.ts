import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ArticleService } from 'src/app/services/article.service';
import { Article } from '../../models/article.model';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  @Input() order: any;

  @Output()
  sendArticles: EventEmitter<any> = new EventEmitter<any>();

  constructor(
    public articleService: ArticleService,
  ) { }

  ngOnInit(): void {
    this.getArticles();

  }

  getArticles() {
    this.articleService.getArticles().then((data: any) => {
      this.articleService.articles$.next(data);
      if (this.order) {
        var articles = this.articleService.articles$.value;
        articles.forEach((element:any) => {
            element.selected=this.checkIfexist(element);
        });
        this.articleService.articles$.next(articles);
      }
     
    }).catch()
  }

  checkIfexist(artcile: Article) {
    return this.order.articles.some((a: { id: number; }) => a.id == artcile.id);
  }
  confirmOrder() {
    var articles = this.articleService.articles$.value;
    articles = articles.filter((artcile: { selected: boolean; }) => artcile.selected)
    articles.forEach((object: { [x: string]: any; }) => {
      delete object['selected'];
    })

    if(this.order){
      this.sendArticles.emit({articles: articles, type: 'edit'})
    }
    else{
      this.sendArticles.emit({articles: articles, type: 'add'})
    }
    
  }


}
