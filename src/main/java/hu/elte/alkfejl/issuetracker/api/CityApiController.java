package hu.elte.alkfejl.issuetracker.api;

import hu.elte.alkfejl.issuetracker.model.City;
import static hu.elte.alkfejl.issuetracker.model.User.Role.BOSS;
import static hu.elte.alkfejl.issuetracker.model.User.Role.MAJOR;
import static hu.elte.alkfejl.issuetracker.model.User.Role.USER;
import hu.elte.alkfejl.issuetracker.service.CityService;
import hu.elte.alkfejl.issuetracker.service.annotations.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cities")
public class CityApiController {
    
    
    @Autowired
    private CityService cityService;
    
    @Role({USER, MAJOR, BOSS})
    @GetMapping
    private ResponseEntity<Iterable<City>> list() {
        Iterable<City> cities = cityService.cities();
        return ResponseEntity.ok(cities);
    }
    
    
    @Role(MAJOR)
    @PostMapping
    private ResponseEntity<City> create(@RequestBody City city) {
        City saved = cityService.create(city);
        return ResponseEntity.ok(saved);
    }
    
    
    @Role({USER, MAJOR, BOSS})
    @GetMapping("/{id}")
    private ResponseEntity<City> read(@PathVariable String id) {
        City read = cityService.read(Integer.parseInt(id));
        return ResponseEntity.ok(read);
    }
    
    @Role(MAJOR)
    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable int id) {
        cityService.delete(id);
        return ResponseEntity.ok().build();
    }
    
    @Role(MAJOR)
    @PutMapping("/{id}")
    private ResponseEntity<City> update(@PathVariable int id, @RequestBody City city) {
        City updated = cityService.update(id, city);
        return ResponseEntity.ok(updated);
    }
}
