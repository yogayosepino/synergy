package org.binarfood.model;
import lombok.*;

import org.binarfood.Data;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Restaurant {
    private int id;
    private String name;
    private String location;
    private boolean status;


//    public List<MenuItem> getMenuItemList() {
//        return Data.MENU_ITEMS.stream()
//                .filter(i -> i.getRestaurant().getId() == this.id)
//                .toList();
//    }
}
