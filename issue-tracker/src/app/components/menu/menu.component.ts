import {Component, OnInit} from '@angular/core';
import {Role} from "../../model/User";
import {AuthService} from "../../services/auth.service";
import {NavigationEnd, Router} from "@angular/router";

interface MenuItem {
  link: String;
  title: String;
}

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent implements OnInit {
  private common: MenuItem[] = [
    {link: '/cities', title: 'Cities'},
    {link: '/restaurants', title: 'Resturants'},
    {link: '/reviews', title: 'Reviews'},
    {link: '/users', title: 'Users'},
  ];

  private roleMenus = new Map<String, MenuItem[]>([
    [Role.GUEST, []],
    [Role.USER, [...this.common]],
    [Role.BOSS, [...this.common]],
    [Role.MAJOR, [...this.common]],
    [Role.ADMIN, [...this.common]]
  ]);

  menus: MenuItem[];

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.setMenus()
      }
    })
  }

  setMenus() {
    if (this.authService.isLoggedIn) {
      this.menus = this.roleMenus.get(this.authService.user.role);
    } else {
      this.menus = this.roleMenus.get(Role.GUEST)
    }
  }

  logout() {
    this.authService.logout().subscribe(
      res => this.router.navigate(['/login']),
      err => err
    );
  }
}
