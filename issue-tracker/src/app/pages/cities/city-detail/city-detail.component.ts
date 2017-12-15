import {Component, OnInit} from '@angular/core';
import {City} from "../../../model/City";
import {CityService} from "../../../services/city.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-city-detail',
  templateUrl: './city-detail.component.html',
  styleUrls: ['./city-detail.component.css']
})
export class CityDetailComponent implements OnInit {
  city: City = new City();
  id: number;

  constructor(private cityService: CityService,
              private route: ActivatedRoute,
              private router: Router) {
    this.route.params.subscribe(
      params => this.id = params.id,
      err => console.log(err)
    )
  }

  ngOnInit() {
    this.cityService.read(this.id)
      .subscribe(
        city => this.city = city,
        err => console.log(err)
      )
  }

  update() {
    this.cityService.update(this.city)
      .subscribe(
        city => console.log('ok'),
        err => console.log(err)
      )
  }

}
