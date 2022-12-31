import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Article } from '../models/article';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  URL = `articles`;
  articles$ = new BehaviorSubject<Article[]>([]);

  constructor(
    private api: ApiService,
  ) { }

  getArticles() {
    let headers = this.api.getHeaders();
    return this.api.get(this.URL, { headers });
  }

  addArticle(Article: any) {

    let headers = this.api.getHeaders();
    const formData = new FormData();
    formData.append('name', Article.name);
    formData.append('price', Article.price.toString());
    formData.append('image', Article.picture);
    return this.api.post(this.URL, formData, { headers });
  }
}

