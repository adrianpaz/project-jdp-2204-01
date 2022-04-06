package com.kodilla.ecommercee.domain;

import lombok.*;

@Data
@AllArgsConstructor

public class UserDto {
    private Long id;
    private String userName;
    private String personalKey;
    private boolean isActive;
    }

