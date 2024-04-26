package com.fady.hotel.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

import com.fady.hotel.Entity.UserRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAuthRequest {

    private String username;
    private String password;
    private Set<UserRole> roles;

}
