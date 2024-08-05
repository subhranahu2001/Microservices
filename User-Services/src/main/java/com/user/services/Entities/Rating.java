package com.user.services.Entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String ratingId;

    private String userId;

    private String HotelId;

    private int rating;

    private String feedback;

    private Hotel hotel;
}
