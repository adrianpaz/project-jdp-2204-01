package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CardDto;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping(value = "/getUsers")
    public List<UserDto> getAllUsers() {
        return new ArrayList<>();

    }
    @GetMapping(value = "/getUsers/userId")
    public UserDto getUser(Long id) {
        return new UserDto(1L, "John Smith", "!@#$", new CardDto(), true);

    }
    @PostMapping(value = "/createUser")
    public void createUser(UserDto userDto) {

    }
    @PutMapping(value = "/updateUser")
    public UserDto updateUser(UserDto userDto) {
        return new UserDto(userDto.getId(), userDto.getUserName(), userDto.getPersonalKey(),
        userDto.getCardDto(), true);
    }
    @PutMapping(value = "/blockUser")
    public UserDto blockUser(UserDto userDto) {
        return new UserDto(userDto.getId(), userDto.getUserName(), userDto.getPersonalKey(),
                userDto.getCardDto(), false);
    }
    @PutMapping(value = "/genereteToken")
    public UserDto generateToken(UserDto userDto) {
        return new UserDto(userDto.getId(), userDto.getUserName(), userDto.getPersonalKey(),
                userDto.getCardDto(), false);
    }
}