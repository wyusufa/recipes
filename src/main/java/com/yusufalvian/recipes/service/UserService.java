package com.yusufalvian.recipes.service;

import com.yusufalvian.recipes.entity.UserEntity;
import com.yusufalvian.recipes.dto.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Authentication getAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public UserEntity getUserEntity() {
        UserDetails userDetails = (UserDetails) getAuth().getPrincipal();
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDetails.getUsername());
        userEntity.setPassword(userDetails.getPassword());
        userEntity.setRole(String.valueOf(userDetails.getAuthorities().toArray()[0]));
        return userEntity;
    }

    public String getAuthUserName() {
        return getAuth().getName();
    }

    public UserEntity toUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setRole(userDTO.getRole());
        return userEntity;
    }


}
