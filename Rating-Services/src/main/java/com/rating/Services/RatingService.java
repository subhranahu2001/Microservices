package com.rating.Services;

import com.rating.Entities.Ratings;

import java.util.List;

public interface RatingService {

    Ratings create(Ratings rating);

    List<Ratings> getAll();

    //find all by userId
    List<Ratings> getByUserId(String userId);

    List<Ratings> getByHotelId(String hotelId);
}
