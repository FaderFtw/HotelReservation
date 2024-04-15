package com.fady.hotel.user;

import java.util.List;

import com.fady.hotel.user.dtos.UserRequest;
import com.fady.hotel.user.dtos.UserResponse;

public interface UserService {

    UserResponse saveUser(UserRequest userRequest);

    UserResponse getUserByUsername(String username);

    UserResponse getUser();

    List<UserResponse> getAllUser();

}
