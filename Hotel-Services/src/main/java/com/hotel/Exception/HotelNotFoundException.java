package com.hotel.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HotelNotFoundException extends RuntimeException {


    public HotelNotFoundException(String message) {
        super(message);
    }
}
