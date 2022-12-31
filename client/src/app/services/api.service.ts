import { HttpHeaders } from "@angular/common/http";
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from "rxjs";
import { environment } from '../../environments/environment';
import { HelpersService } from './helpers.service';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  url: string = environment.api;

  constructor(
    private http: HttpClient,
  ) { }

  getApiUrl() {
    return this.url;
  }

  getHeaders() {
    return new HttpHeaders({
      Accept: "application/json"
    });
  }

  getHeadersData() {
    return new HttpHeaders({
      "content-type": "multipart/form-data",

    });
  }



   get(endpoint: string, reqOpts?: any) {
    return  lastValueFrom(this.http.get(this.url + '/' + endpoint, reqOpts));
  }



  post(endpoint: string, body: any, reqOpts?: any) {
    return lastValueFrom(this.http.post(this.url + '/' + endpoint, body, reqOpts));
  }

   put(endpoint: string, body: any, reqOpts?: any) {
    return  lastValueFrom(this.http.put(this.url + '/' + endpoint, body, reqOpts));
  }

   delete(endpoint: string, reqOpts?: any) {
    return  lastValueFrom(this.http.delete(this.url + '/' + endpoint, reqOpts));
  }

  patch(endpoint: string, body: any, reqOpts?: any) {
    return this.http.patch(this.url + '/' + endpoint, body, reqOpts).toPromise();
  }
}
