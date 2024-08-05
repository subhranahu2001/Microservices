package com.hotel.Controller;

import com.hotel.Entities.Hotel;
import com.hotel.Repository.HotelRepository;
import com.hotel.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepository hotelRepository;

    //create
    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {

        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);

    }

    //get single
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId) {
        Hotel hotel = hotelService.getHotel(hotelId);

        return ResponseEntity.ok(hotel);
    }

    //get all hotels
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getHotelList() {
        return ResponseEntity.ok(hotelService.getHotels());
    }
}
