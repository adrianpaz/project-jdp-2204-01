package com.kodilla.ecommercee.domain;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor

public class UserDto {
    private Long id;
    private String userName;
    private String personalKey;
    }

