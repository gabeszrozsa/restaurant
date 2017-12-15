package hu.elte.alkfejl.issuetracker.repository;

import hu.elte.alkfejl.issuetracker.model.Restaurant;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gabesz
 */
@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
}
