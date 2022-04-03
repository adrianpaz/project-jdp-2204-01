package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getPersonalKey()
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getPersonalKey()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> usersList) {
        return usersList.stream()
                .map(t -> new UserDto(t.getId(), t.getUserName(), t.getPersonalKey()))
                .collect(Collectors.toList());
    }
}

