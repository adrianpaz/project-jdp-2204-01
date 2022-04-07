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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PERSONALKEY")
    private String personalKey;

    // @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // implementation after fix the database structure
    // @JoinColumn(name = "CART_ID")
    // private Cart Cart;

    @Column(name = "ISACTIVE")
    private boolean isActive;

    // @ManyToOne(cascade = CascadeType.PERSIST)//// implementation after fix the database structure
    // @JoinColumn(name = "ORDER_ID")
    //  public Order order;
}

