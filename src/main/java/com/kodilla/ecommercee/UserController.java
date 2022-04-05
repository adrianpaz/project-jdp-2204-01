package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import lombok.Data;
import lombok.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/v1/user")
@Validated
public class UserController {


    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(0,new UserDto(1L,"userName", "123456"));
        userDtoList.add(1,new UserDto(2L,"userName1", "123456dsads"));
        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        UserDto userDto = new UserDto(1L, "UserName", "123456");
        return ResponseEntity.ok(userDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userDto);
    }

    @PutMapping(value = "/{blockUser}")
    public ResponseEntity<UserDto> blockUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/getToken/{userId}") // in progress.........
    ResponseEntity<String> getToken(@PathVariable Long userId)  {
        Random random = new Random();
        String tokenUserKey = String.valueOf(random.nextInt(99999999)) ;
        return ResponseEntity.ok("Your personal key for userID:" + userId +  "=" + tokenUserKey);
    }
}

