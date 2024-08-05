package com.rating.Controller;

import com.rating.Entities.Ratings;
import com.rating.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //create rating service
    @PostMapping("/create")
    public ResponseEntity<Ratings> create(@RequestBody Ratings ratings) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(ratings));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ratings>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Ratings>> getAllRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.getByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Ratings>> getAllRatingsByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.getByHotelId(hotelId));
    }

}
