package com.hotel.Services;

import com.hotel.Entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getHotels();

    Hotel getHotel(String id);
}
