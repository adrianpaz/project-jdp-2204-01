package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;
import java.math.BigDecimal;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
        private Long id;

        //@Column(name = "NAME")
        private String name;

        // @Column(name = "PRICE")
        private BigDecimal price;

        // @Column(name = "GROUP")
        private GroupDto groupDto;
    }
