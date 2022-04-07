package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*Temporary Product class, needed for the implementation of related DTO, Mapper, Repository controller and DB Service
within given task
Further addition of Entity features required*/

/*Final form of relations (e.g. 1:N, N:1, etc.) between Product and the rest of possible entities:
        Product, User, Cart, Order and Group of Products - to be established within task JDP220401-12*/

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")
@Data
public class Product {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "PRODUCT_ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Order> orders = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Cart> carts = new ArrayList<>();

}
