package com.yoga.binarfut.model;
//package com.example.Binarfood.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@SQLDelete(sql = "update menu_item set deleted = true where id =?")
@SQLRestriction("deleted = false")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime orderTime;
    private String destination;
    private boolean statusOrder; //true if complete

    private boolean deleted = Boolean.FALSE;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @JsonIgnore
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "customer_id")
    private User customer;

    @JsonIgnore
    @ManyToOne(targetEntity = Merchant.class)
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;
}

