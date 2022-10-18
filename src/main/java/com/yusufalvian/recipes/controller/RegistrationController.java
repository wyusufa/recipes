package com.yusufalvian.recipes.controller;

import com.yusufalvian.recipes.dto.UserDTO;
import com.yusufalvian.recipes.entity.UserEntity;
import com.yusufalvian.recipes.repository.UserRepository;
import com.yusufalvian.recipes.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController {
    final PasswordEncoder encoder;
    final UserRepository userRepository;
    final UserService userService;

    public RegistrationController(PasswordEncoder encoder, UserRepository userRepository, UserService userService) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/api/register")
    public ResponseEntity register(@Valid @RequestBody UserDTO userDTO) {

        UserEntity userEntityByUsername = userRepository.findUserEntityByUsername(userDTO.getUsername());
        // if user is not in DB, save to DB
        if (userEntityByUsername == null) {
            UserEntity userEntity = userService.toUserEntity(userDTO);
            userEntity.setPassword(encoder.encode(userEntity.getPassword()));
            userRepository.save(userEntity);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
