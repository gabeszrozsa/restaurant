package hu.elte.alkfejl.issuetracker.api;

import hu.elte.alkfejl.issuetracker.model.Review;
import static hu.elte.alkfejl.issuetracker.model.User.Role.BOSS;
import static hu.elte.alkfejl.issuetracker.model.User.Role.MAJOR;
import static hu.elte.alkfejl.issuetracker.model.User.Role.USER;
import hu.elte.alkfejl.issuetracker.service.ReviewService;
import hu.elte.alkfejl.issuetracker.service.UserService;
import hu.elte.alkfejl.issuetracker.service.annotations.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewApiController {
    
    
    @Autowired
    private ReviewService reviewService;
    
    @Autowired
    private UserService userService;
    
    @Role({USER, MAJOR, BOSS})
    @GetMapping
    private ResponseEntity<Iterable<Review>> list() {
        Iterable<Review> reviews = reviewService.reviews();
        return ResponseEntity.ok(reviews);
    }
    
    
    @Role({USER, MAJOR, BOSS})
    @PostMapping
    private ResponseEntity<Review> create(@RequestBody Review review) {
        Review saved = reviewService.create(review);
        return ResponseEntity.ok(saved);
    }
    
    
    @Role({USER, MAJOR, BOSS})
    @GetMapping("/{id}")
    private ResponseEntity<Review> read(@PathVariable String id) {
        Review read = reviewService.read(Integer.parseInt(id));
        return ResponseEntity.ok(read);
    }
    
    @Role(MAJOR)
    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable int id) {
        reviewService.delete(id);
        return ResponseEntity.ok().build();
    }
    
    @Role({USER, MAJOR, BOSS})
    @PutMapping("/{id}")
    private ResponseEntity<Review> update(@PathVariable int id, @RequestBody Review review) {
        Review updated = reviewService.update(id, review, userService.getUser());
        return ResponseEntity.ok(updated);
    }
}
