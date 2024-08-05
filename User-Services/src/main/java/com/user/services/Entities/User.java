package com.user.services.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String userId;

    @Column(length = 30)
    private String name;

    @Column(unique = true)
    private String email;

    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
