package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
   private final  Long id;
   private final String userName;
   private final String personalKey;
   private CardDto cardDto;
   private final boolean isActive;
}
