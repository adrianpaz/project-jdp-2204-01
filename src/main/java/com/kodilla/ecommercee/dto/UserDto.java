package com.kodilla.ecommercee.dto;

import lombok.*;

@Data
@AllArgsConstructor

public class UserDto {
    private Long id;
    private String userName;
    private String personalKey;
    private boolean isActive;
    }

