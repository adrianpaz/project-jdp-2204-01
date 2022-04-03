package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "USERS")

public class User {


    public User(Long id, String userName, String personalKey) {
        this.id = id;
        this.userName = userName;
        this.personalKey = personalKey;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PERSONALKEY")
    private String personalKey;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    private Cart Cart;

    @Column(name = "ISACTIVE")
    private boolean isActive;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ORDER_ID")
    public Order order;


}

