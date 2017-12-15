import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {City} from "../../../model/City";
import {CityService} from "../../../services/city.service";

@Component({
  selector: 'app-city-new',
  templateUrl: './city-new.component.html',
  styleUrls: ['./city-new.component.css']
})
export class CityNewComponent implements OnInit {
  cityForm: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required])
  });

  constructor(private cityService: CityService) {

  }

  ngOnInit() {
  }

  get name() {
    return this.cityForm.get('name')
  }


  submit() {
    const id = Math.floor(Math.random()*10000000)
    const newCity = new City(id, this.name.value)

    this.cityService.create(newCity)
      .subscribe(
        res => res,
        err => console.log(err)
      )
  }
}
