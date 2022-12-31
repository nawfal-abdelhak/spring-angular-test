import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormControl } from '@angular/forms'
import { Router } from '@angular/router';
import { ArticleService } from 'src/app/services/article.service';
@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit {


  constructor(private fb: FormBuilder,
    private articleService: ArticleService,
    public router: Router) { }

  articleForm: any;
  file: any = null;
  image: string = "";
  ngOnInit(): void {

    this.articleForm = this.fb.group(
      {
        name: new FormControl('', Validators.required),
        price: new FormControl(0, [Validators.required]),
        picture: new FormControl('', [Validators.required]),
      }
    );
  }

  handleFileInput(e: any) {
    if (e.target.files.length > 0) {
      this.file = e.target.files[0]
    }
  }

  addArticle() {
    this.articleForm.value.picture = this.file;
    this.articleService.addArticle(this.articleForm.value).then((data: any) => {
      this.router.navigate(['/articles'])
    }).catch(e => {
    })
  }

}
