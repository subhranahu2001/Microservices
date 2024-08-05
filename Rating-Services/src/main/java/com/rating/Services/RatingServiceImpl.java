package com.rating.Services;

import com.rating.Entities.Ratings;
import com.rating.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Ratings create(Ratings rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Ratings> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Ratings> getByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Ratings> getByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
