package org.binarfood.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Order {
    private final Menu menuItem;
    private int qty;
    private int price;

    public Order(Menu menuItem, int qty) {
        this.menuItem = menuItem;
        this.qty = qty;
        this.price = menuItem.getPrice();
    }

    public Order(Menu menuItem, int qty, int price) {
        this.menuItem = menuItem;
        this.qty = qty;
        this.price = menuItem.getPrice();
    }

    public void addQty(int qty) {

        this.qty += qty;
    }
}
