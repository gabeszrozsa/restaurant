package hu.elte.alkfejl.issuetracker.service;

import hu.elte.alkfejl.issuetracker.model.City;
import hu.elte.alkfejl.issuetracker.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;
    
    public Iterable<City> cities() {
        return cityRepository.findAll();
    }
    
    public City create(City city) {
        return cityRepository.save(city);
    }
    
    public City read(int id) {
        return cityRepository.findOne(id);
    }
    
    public void delete(int id) {
        cityRepository.delete(id);
    }
    
    public City update(int id, City city) {
        City currentCity = cityRepository.findOne(id);

        currentCity.setName(city.getName());
        return cityRepository.save(currentCity);
    }
}
