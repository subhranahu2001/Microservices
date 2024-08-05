package com.rating.Repository;

import com.rating.Entities.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Ratings,String> {

    List<Ratings> findByUserId(String userId);

    List<Ratings> findByHotelId(String hotelId);
}
