package com.user.services.Services;

import com.user.services.Entities.Hotel;
import com.user.services.Entities.Rating;
import com.user.services.Entities.User;
import com.user.services.Exception.ResourceNotFoundException;
import com.user.services.External.Services.HotelServices;
import com.user.services.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServices hotelServices;


    @Override
    public User saveUser(User user) {
        String randomUUID = UUID.randomUUID().toString();
        user.setUserId(randomUUID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list =  userRepository.findAll();
        List<User> userList = list.stream()
                .peek(user -> {
                    //api call to get ratings of each user
                    ResponseEntity<Rating[]> forEntity = restTemplate.getForEntity("http://RATING-SERVICES/ratings/users/" + user.getUserId(), Rating[].class);
                    Rating[] ratings = forEntity.getBody();
                    assert ratings != null;
                    List<Rating> ratingList = Arrays.stream(ratings).toList();

                    //api call to get hotels of each user
                    List<Rating> listOfRatings = ratingList.stream()
                            .peek(rating -> {
                                // api call to the hotel service
                                ResponseEntity<Hotel> entity = restTemplate.getForEntity("http://HOTEL-SERVICES/hotels/" + rating.getHotelId(), Hotel.class);
                                Hotel hotel = entity.getBody();
                                rating.setHotel(hotel);
                            }).toList();
                    user.setRatings(listOfRatings);
                }).toList();

        return userList;
    }

    @Override
    public User getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        //fetching rating of the above user from Rating service
        //http://localhost:8087/ratings/users/6c5b5616-000a-4049-b2b8-725a8755800c
        Rating[] forObject = restTemplate.getForObject("http://RATING-SERVICES/ratings/users/" + user.getUserId(), Rating[].class);
        assert forObject != null;
        List<Rating> ratings = Arrays.stream(forObject).toList();
        List<Rating> listOfRatings = ratings.stream().peek(rating -> {
            //api call to hotel service to get the hotel
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICES/hotels/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();
//            log.info("response status code: {}", forEntity.getStatusCode());
            Hotel hotel = hotelServices.getHotel(rating.getHotelId());

            // set the hotel to ratings
            rating.setHotel(hotel);

        }).toList();
        user.setRatings(listOfRatings);
        return user;
    }
}
