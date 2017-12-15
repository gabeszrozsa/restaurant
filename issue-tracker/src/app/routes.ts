import {Routes} from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {RegisterComponent} from "./pages/register/register.component";

import {IssueListComponent} from "./pages/issues/issue-list/issue-list.component";
import {IssueDetailComponent} from "./pages/issues/issue-detail/issue-detail.component";
import {NewIssueComponent} from "./pages/issues/new-issue/new-issue.component";

import {CityListComponent} from "./pages/cities/city-list/city-list.component";
import {CityDetailComponent} from "./pages/cities/city-detail/city-detail.component";
// import {NewCityComponent} from "./pages/cities/new-city/new-city.component";

import {HelpComponent} from "./pages/help/help.component";
import {ErrorComponent} from "./pages/error/error.component";
import {Role} from "./model/User";
import {RouteGuard} from "./route.guard";

const loggedInUsers = [Role.USER, Role.ADMIN, Role.BOSS, Role.MAJOR];

export const appRoutes: Routes = [
  {
    path: '',
    canActivateChild: [RouteGuard],
    children: [
      {path: '', redirectTo: 'login', pathMatch: 'full'},
      {path: 'login', component: LoginComponent, data: {roles: [Role.GUEST]}},
      {path: 'register', component: RegisterComponent, data: {roles: [Role.GUEST]}},
      {path: 'issues', component: IssueListComponent, data: {roles: [Role.USER, Role.ADMIN]}},
      {path: 'issues/new', component: NewIssueComponent, data: {roles: [Role.USER, Role.ADMIN]}},
      {path: 'issues/:id', component: IssueDetailComponent, data: {roles: [Role.USER, Role.ADMIN]}},

      {path: 'cities', component: CityListComponent, data: {roles: loggedInUsers}},
      // {path: 'cities/new', component: NewCityComponent, data: {roles: [Role.USER, Role.ADMIN]}},
      {path: 'cities/:id', component: CityDetailComponent, data: {roles: [Role.USER, Role.ADMIN]}},
      {path: 'help', component: HelpComponent},
      {path: '**', component: ErrorComponent}
    ]
  }];
