import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/User';
import { JwtHelperService } from '@auth0/angular-jwt';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private jwtToken: any;
  private roles: Array<any> = [];
  private hostname: string = environment.host;

  userInfo = new BehaviorSubject(null);
  jwtHelper = new JwtHelperService();


  constructor(private http: HttpClient) { }


  //form login
  login(user: User) {
    return this.http.post(this.hostname + "/login", user, { observe: 'response' });
  }

  saveToken(jwt: any) {
    this.jwtToken = jwt;
    localStorage.setItem('token', jwt);
    this.roles = this.jwtHelper.decodeToken(this.jwtToken).roles;
    this.isAdmin();
  }

  loadToken() {
    this.jwtToken = localStorage.getItem('token');
  }

  getRessources() {
    this.loadToken();
    return this.http.get(this.hostname + "/ressource/all",
      { headers: new HttpHeaders().set("Authorization", this.jwtToken) });
  }


  logout() {
    this.jwtToken = null;
    localStorage.removeItem('token');
  }


  isAdmin() {
    for (let r of this.roles) {
      console.log(r.authority)
      if (r.authority == 'ADMIN') return true;
    }
    return true;
  }


}
