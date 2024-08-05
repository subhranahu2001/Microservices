package com.user.services.Services;

import com.user.services.Entities.User;

import java.util.List;

public interface UserService {

    //user operations

    //create
    User saveUser(User user);

    //get all users
    List<User> getAllUsers();

    //get user by id
    User getUserById(String id);
}
