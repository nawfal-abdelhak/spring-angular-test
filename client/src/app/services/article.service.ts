import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Article } from '../models/article.model';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  URL = `articles`;
  articles$ = new BehaviorSubject<any>(null);

  constructor(
    private api: ApiService,
  ) { }

  getArticles() {
    let headers = this.api.getHeaders();
    return this.api.get(this.URL, { headers });
  }

  addArticle(Article: any) {
    
    let headers = this.api.getHeaders();
   
    // var genres = JSON.stringify(genre);
   console.log(Article.image)
    const formData = new FormData();
    formData.append('name', Article.name);
    formData.append('price',Article.price.toString() );
    formData.append('image', Article.picture);
    
    return this.api.post(this.URL,formData, { headers });
  }
}

