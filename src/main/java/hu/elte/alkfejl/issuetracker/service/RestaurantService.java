package hu.elte.alkfejl.issuetracker.service;

import hu.elte.alkfejl.issuetracker.model.Restaurant;
import hu.elte.alkfejl.issuetracker.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    
    @Autowired
    private RestaurantRepository restaurantRepository;
    
    public Iterable<Restaurant> restaurants() {
        return restaurantRepository.findAll();
    }
    
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
    
    public Restaurant read(int id) {
        return restaurantRepository.findOne(id);
    }
    
    public void delete(int id) {
        restaurantRepository.delete(id);
    }
    
    public Restaurant update(int id, Restaurant restaurant) {
        Restaurant currentRestaurant = restaurantRepository.findOne(id);

        currentRestaurant.setName(restaurant.getName());
        currentRestaurant.setAddress(restaurant.getAddress());
        currentRestaurant.setCity(restaurant.getCity());
        return restaurantRepository.save(currentRestaurant);
    }
}