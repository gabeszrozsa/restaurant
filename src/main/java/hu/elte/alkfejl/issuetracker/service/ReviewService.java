package hu.elte.alkfejl.issuetracker.service;

import hu.elte.alkfejl.issuetracker.model.Review;
import hu.elte.alkfejl.issuetracker.model.User;
import hu.elte.alkfejl.issuetracker.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;
    
    public Iterable<Review> reviews() {
        return reviewRepository.findAll();
    }
    
    public Review create(Review review) {
        return reviewRepository.save(review);
    }
    
    public Review read(int id) {
        return reviewRepository.findOne(id);
    }
    
    public void delete(int id) {
        reviewRepository.delete(id);
    }
    
    public Review update(int id, Review city, User user) {
        Review currentReview = reviewRepository.findOne(id);
        if (user.getId() == currentReview.getUser().getId()) {
            currentReview.setRating(city.getRating());
            currentReview.setRestaurant(city.getRestaurant());
            return reviewRepository.save(currentReview);
        } else {
            return currentReview;
        }
    }
}