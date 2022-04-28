import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/User';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
mode:number=0;

  
  constructor(private router: Router, private auth:AuthService) { }

  ngOnInit(): void {
 
  }

      onLogin(formData:any){
        
        this.auth.login(formData).subscribe(
          resp=>{
           let jwt = resp.headers.get('Authorization');
           this.auth.saveToken(jwt);
           this.router.navigateByUrl('/dashboard');
           console.log(resp.headers.get('Authorization'));
           
          }, err=>{
            this.mode=1;
            console.log("not word");
          }
        )
    
      }
}
