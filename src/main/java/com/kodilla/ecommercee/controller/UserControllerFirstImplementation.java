package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserControllerFirstImplementation {


    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping(value = "/userId")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        UserDto userDto = new UserDto(1L, "UserName", "123456");
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userDto);
    }

    @PutMapping(value = "/blockUser")
    public ResponseEntity<UserDto> blockUserId(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(value = "/generateToken")
    public ResponseEntity<UserDto> generateToken(@RequestBody UserDto userDto) {
        // token controller ->>>>>>>>>>>
        return ResponseEntity.ok(userDto);
    }
}

