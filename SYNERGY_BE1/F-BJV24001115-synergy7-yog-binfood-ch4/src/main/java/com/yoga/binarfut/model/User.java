package com.yoga.binarfut.model;

//package com.example.Binarfood.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@SQLDelete(sql = "update users set deleted = true where id =?")
@SQLRestriction("deleted = false")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean deleted = Boolean.FALSE;

    public enum Role {
        SELLER, CUSTOMER
    }

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Merchant> merchants;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

}

