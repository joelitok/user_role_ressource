import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {

  private u: any = sessionStorage.getItem('username');
  private i: any = sessionStorage.getItem('id');
  role = sessionStorage.getItem('roles')?.search("ROLE_ADMIN") != -1 ? "admin" : "user";

  username = JSON.parse(this.u);
  id = JSON.parse(this.i);

  constructor(private router: Router) { }

  ngOnInit(): void {

  }

  goTo(){
    this.router.navigate([this.role]);
  }

  closeSession(){
    sessionStorage.clear();
    this.router.navigate(['/login']);
  }

}
