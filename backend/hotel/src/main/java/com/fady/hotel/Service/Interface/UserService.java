package com.fady.hotel.Service.Interface;

import java.util.List;

import com.fady.hotel.Dto.UserRequest;
import com.fady.hotel.Dto.UserResponse;

public interface UserService {

    UserResponse saveUser(UserRequest userRequest);

    UserResponse getUserByUsername(String username);

    UserResponse getUser();

    List<UserResponse> getAllUser();

}
