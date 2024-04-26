package com.fady.hotel.Service;

import com.fady.hotel.Entity.UserInfo;
import com.fady.hotel.Dto.UserRequest;
import com.fady.hotel.Dto.UserResponse;
import com.fady.hotel.Repository.UserRepository;
import com.fady.hotel.Service.Interface.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        if (userRequest.getUsername() == null) {
            throw new RuntimeException("Parameter username is not found in request..!!");
        } else if (userRequest.getPassword() == null) {
            throw new RuntimeException("Parameter password is not found in request..!!");
        }
        // Unique username validation
        UserInfo userByUsername = userRepository.findByUsername(userRequest.getUsername());
        if (userByUsername != null && userRequest.getId() == null) {
            throw new RuntimeException("Username already exists..!!");
        }

        UserInfo savedUser = null;

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = userRequest.getPassword();
        String encodedPassword = encoder.encode(rawPassword);

        UserInfo user = modelMapper.map(userRequest, UserInfo.class);
        user.setPassword(encodedPassword);
        if (userRequest.getId() != null) {
            UserInfo oldUser = userRepository.findFirstById(userRequest.getId());
            if (oldUser != null) {
                oldUser.setId(user.getId());
                oldUser.setPassword(user.getPassword());
                oldUser.setUsername(user.getUsername());
                oldUser.setRoles(user.getRoles());

                savedUser = userRepository.save(oldUser);
            } else {
                throw new RuntimeException("Can't find record with identifier: " + userRequest.getId());
            }
        } else {
            // user.setCreatedBy(currentUser);
            savedUser = userRepository.save(user);
        }
        UserResponse userResponse = modelMapper.map(savedUser, UserResponse.class);
        return userResponse;
    }

    @Override
    public UserResponse getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
        String usernameFromAccessToken = userDetail.getUsername();
        UserInfo user = userRepository.findByUsername(usernameFromAccessToken);
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<UserInfo> users = (List<UserInfo>) userRepository.findAll();
        Type setOfDTOsType = new TypeToken<List<UserResponse>>() {
        }.getType();
        List<UserResponse> userResponses = modelMapper.map(users, setOfDTOsType);
        return userResponses;
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        UserInfo user = userRepository.findByUsername(username);
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return userResponse;
    }

}
