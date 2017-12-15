import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router'

import {AppComponent} from './app.component';
import {LoginComponent} from './pages/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "./services/auth.service";
import {HttpModule} from "@angular/http";
import { RegisterComponent } from './pages/register/register.component';
import  {appRoutes} from './routes';
import {MaterialItemsModule} from "./MaterialItemsModule";
import { MenuComponent } from './components/menu/menu.component';
import { HelpComponent } from './pages/help/help.component';
import { ErrorComponent } from './pages/error/error.component';
import {RouteGuard} from "./route.guard";

import { IssueDetailComponent } from './pages/issues/issue-detail/issue-detail.component';
import { IssueListComponent } from './pages/issues/issue-list/issue-list.component';
import { NewIssueComponent } from './pages/issues/new-issue/new-issue.component';

import {CityListComponent} from "./pages/cities/city-list/city-list.component";
import {CityDetailComponent} from "./pages/cities/city-detail/city-detail.component";
// import {NewCityComponent} from "./pages/cities/new-city/new-city.component";

import { StatsComponent } from './pages/stats/stats.component';
import {IssueService} from "./services/issue.service";

import {CityService} from "./services/city.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,

    IssueDetailComponent,
    IssueListComponent,
    NewIssueComponent,
    StatsComponent,

    CityDetailComponent,
    CityListComponent,
    MenuComponent,
    HelpComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    MaterialItemsModule
  ],
  providers: [AuthService, IssueService, CityService, RouteGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
