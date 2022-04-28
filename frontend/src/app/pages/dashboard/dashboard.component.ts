import { Component, OnInit } from '@angular/core';
import { Resources } from 'src/app/models/Resouces';
import { AuthService } from 'src/app/services/auth.service';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor(private dataSrivice: DataService, public auth: AuthService) { }

  resource = new Resources();

  all_R: Resources[] = [];
  user_R: Resources[] = [];
  id: string = "";

  ngOnInit(): void {
    this.allResources();

  }

  create(){
    this.dataSrivice.createResource(this.resource).subscribe(response => {
      console.log(response);
    })
  }

  add(resourceUser: Resources) {
    this.dataSrivice.addResource(resourceUser).subscribe(response => {
      console.log(response);
    })
  }

  allResources() {
    this.dataSrivice.getAllResources().subscribe(response => {
      this.all_R = response;
    })
  }

  resourcesUser() {
    this.dataSrivice.getUserResources().subscribe(response => {
      console.log(response);
    })
  }

  delete() {
    this.dataSrivice.deleteResource(this.id).subscribe(response => {
      console.log(response);
    })
  }

}
