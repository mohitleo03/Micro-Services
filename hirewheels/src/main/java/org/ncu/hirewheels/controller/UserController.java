package org.ncu.hirewheels.controller;

import javax.validation.Valid;

import org.ncu.hirewheels.dto.Request.GetUserRequestDto;
import org.ncu.hirewheels.dto.Request.UserRequestDto;
import org.ncu.hirewheels.dto.Response.UserResponseDto;
import org.ncu.hirewheels.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRequestDto userDto) {
        try {
            UserResponseDto user = userService.createUser(userDto);
            return new ResponseEntity<UserResponseDto>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> getUser(@Valid @RequestBody GetUserRequestDto getUserRequestDto) {
        try {
            UserResponseDto user = userService.getUser(getUserRequestDto.getEmail(), getUserRequestDto.getPassword());
            return new ResponseEntity<UserResponseDto>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
