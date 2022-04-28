import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule, registerLocaleData } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CdkTableModule } from "@angular/cdk/table";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { ModalModule } from 'ngx-bootstrap/modal';
import localeFr from '@angular/common/locales/fr';
import { AuthInterceptor } from './interceptor/auths.interceptor';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LoginComponent } from './auths/login/login.component';


registerLocaleData(localeFr);

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    CommonModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CdkTableModule,
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot()
  ],
  exports: [
    CdkTableModule,
    BsDropdownModule,
    TooltipModule,
    ModalModule
  ],
  providers: [
    {useClass: AuthInterceptor, provide: HTTP_INTERCEPTORS, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
