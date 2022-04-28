import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Resources } from '../models/Resouces';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private readonly url_signin = environment.host + "/login";
  private readonly getAllResourceUrl = environment.host + "/ressource/all";
  private readonly getUserResourceUrl = environment.host + "/";
  private readonly createResourceUrl = environment.host + "/ressource/new";
  private readonly updateResourceUrl = environment.host + "/";
  private readonly deleteResourceUrl = environment.host + "/";
  private readonly addResourceUrl = environment.host + "/";

  constructor(private http: HttpClient) { }


  signIn(user: any): Observable<any> {
    return this.http.post(this.url_signin, user);
  }


  getAllResources(): Observable<Resources[]> {

    return this.http.get<Resources[]>(this.getAllResourceUrl);

  }

  getUserResources(): Observable<Resources> {

    return this.http.get<Resources>(this.getUserResourceUrl);

  }


  createResource(r: Resources): Observable<Resources> {

    return this.http.post<Resources>(this.createResourceUrl, r);

  }

  addResource(ur: Resources): Observable<Resources> {

    return this.http.post<Resources>(this.addResourceUrl, ur);

  }

  deleteResource(id: string): Observable<any> {

    return this.http.delete(this.deleteResourceUrl + id);

  }








}
