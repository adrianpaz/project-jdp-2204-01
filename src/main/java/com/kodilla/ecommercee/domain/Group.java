package com.kodilla.ecommercee.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="GROUPS")
public class Group {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name="GROUP_ID", unique=true)
    private Long id;

    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )

    private List<Product> products = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }
}
