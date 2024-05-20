package com.yoga.binarfut.model;

//package com.example.Binarfood.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
@SQLDelete(sql = "update order_detail set deleted = true where id =?")
@SQLRestriction("deleted = false")
public class OrderDetail    {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int qty;

    private int price;

    private boolean deleted = Boolean.FALSE;

    @JsonIgnore
    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    private Order order;

    @JsonIgnore
    @ManyToOne(targetEntity = Menu.class)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public void addQty(int qty) {
        this.qty += qty;
    }
}

