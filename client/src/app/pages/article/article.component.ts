import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ArticleService } from 'src/app/services/article.service';
import { Article } from '../../models/article';

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
        articles.forEach((artcile: Article) => {
          artcile.selected = this.checkIfexist(artcile);
        });
        this.articleService.articles$.next(articles);
      }
    }).catch()
  }

  checkIfexist(artcile: Article) {
    return this.order.articles.some((a: Article) => a.id == artcile.id);
  }
  confirmOrder() {
    var articles = this.articleService.articles$.value;
    articles = articles.filter((artcile: Article) => artcile.selected)
    this.order ? this.sendArticles.emit({ articles: articles, type: 'edit' }) : this.sendArticles.emit({ articles: articles, type: 'add' })
  }

}
