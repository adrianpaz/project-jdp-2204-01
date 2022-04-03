/*
package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("/v1/user")
public class UserController {


    private final UserService userService;
    private final UserMapper userMapper;


    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity <List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(userMapper.mapToUserDtoList(users));
    }

    @GetMapping(value = "/userId")
    public  ResponseEntity<UserDto> getUser(@PathVariable Long userId) throws UserNotFoundException {
        return ResponseEntity.ok(userMapper.mapToUserDto(userService.getUser(userId)));

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userService.saveUser(user);
        return ResponseEntity.ok().build();

    }
      @PutMapping(value = "/blockUser")
    public ResponseEntity<UserDto> blockUserId (@RequestBody UserDto userDto ) {
        User user = userMapper.mapToUser(userDto);
        User saveUser = userService.saveUser(user);
        return ResponseEntity.ok(userMapper.mapToUserDto(saveUser));

    }
    @PostMapping(value = "/generateToken")
    public UserDto generateToken(@RequestBody UserDto userDto)  {
       // token controller ->>>>>>>>>>>
       return null;

    }
}

*/