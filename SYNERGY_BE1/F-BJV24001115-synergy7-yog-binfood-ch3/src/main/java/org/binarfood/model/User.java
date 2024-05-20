package org.binarfood.model;

import lombok.*;
import java.util.List;

import org.binarfood.Data;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private Role role;


    public enum Role{
        SELLER, CUSTOMER
    }

//    public List<Order> getOrderList() {
//        return Data.ORDERS.stream()
//                .filter(o -> o.getUser().getId() == this.id)
//                .toList();
//    }
}
