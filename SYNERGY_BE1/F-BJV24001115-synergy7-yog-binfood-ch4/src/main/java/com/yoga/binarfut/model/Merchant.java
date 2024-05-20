package com.yoga.binarfut.model;
//package com.example.Binarfood.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "merchants")
@SQLDelete(sql = "update menu_item set deleted = true where id =?")
@SQLRestriction("deleted = false")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String address;
    private boolean open = Boolean.TRUE;

    private boolean deleted = Boolean.FALSE;

    @JsonIgnore
    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
    private List<Menu> menu;

    @JsonIgnore
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "owner_id")
    private User owner;
}

