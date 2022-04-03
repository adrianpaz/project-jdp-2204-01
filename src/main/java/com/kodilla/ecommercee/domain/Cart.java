package com.kodilla.ecommercee.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID", unique = true)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "CART_ID",referencedColumnName = "CART_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID",referencedColumnName = "PRODUCT_ID")})
    private List<Product> productList;

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ORDER_ID")
    private Order order;


}
