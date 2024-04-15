package com.fady.hotel.user;

import com.fady.hotel.authentification.JwtService;
import com.alaa.hotel.authentification.dtos.*;
import com.fady.hotel.authentification.dtos.AuthRequestDTO;
import com.fady.hotel.authentification.dtos.JwtResponseDTO;
import com.fady.hotel.user.dtos.UserAuthRequest;
import com.fady.hotel.user.dtos.UserRequest;
import com.fady.hotel.user.dtos.UserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserAuthRequest userAuthRequest) {
        // Cannot create Admin user without being an admin
        if (userAuthRequest.getRoles().contains("ROLE_ADMIN")
                && !userService.getUser().getRoles().contains("ROLE_ADMIN")) {
            throw new RuntimeException("Admin user creation is restricted");
        }
        try {
            UserRequest userRequest = new UserRequest(null, userAuthRequest.getUsername(),
                    userAuthRequest.getPassword(),
                    userAuthRequest.getRoles());
            UserResponse userResponse = userService.saveUser(userRequest);
            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        try {
            List<UserResponse> userResponses = userService.getAllUser();
            return ResponseEntity.ok(userResponses);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getUserProfile() {
        try {
            UserResponse userResponse = userService.getUser();
            return ResponseEntity.ok().body(userResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public JwtResponseDTO AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if (authentication.isAuthenticated()) {
            return JwtResponseDTO.builder()
                    .accessToken(jwtService.GenerateToken(authRequestDTO.getUsername()))
                    .build();

        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }

}
