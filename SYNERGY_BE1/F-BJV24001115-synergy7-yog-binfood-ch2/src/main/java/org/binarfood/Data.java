package org.binarfood;

import java.util.ArrayList;
import java.util.List;

import org.binarfood.model.*;
public class Data {
    public static final List<Menu> menu = new ArrayList<>();
    public static final List<Order> orders = new ArrayList<>();

    public static void initializeMenu() {
        menu.add(new Menu("Nasi Goreng", Menu.FoodType.FOOD, 15000));
        menu.add(new Menu("Mie Goreng", Menu.FoodType.FOOD, 13000));
        menu.add(new Menu("Nasi + Ayam", Menu.FoodType.FOOD, 18000));
        menu.add(new Menu("Es Teh Manis", Menu.FoodType.DRINK, 3000));
        menu.add(new Menu("Es Jeruk", Menu.FoodType.DRINK, 5000));
    }
}
