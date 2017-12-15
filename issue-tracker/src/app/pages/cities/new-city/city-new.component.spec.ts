import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CityNewComponent } from './new-city.component';

describe('CityNewComponent', () => {
  let component: CityNewComponent;
  let fixture: ComponentFixture<CityNewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CityNewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CityNewComponent);
    component = fixture.componentInstance;
    fsxture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
