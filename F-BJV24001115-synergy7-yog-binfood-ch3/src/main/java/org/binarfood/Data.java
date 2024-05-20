package org.binarfood;

import org.binarfood.model.*;

import java.util.ArrayList;
import java.util.List;
public class Data {
    public static final List<User> USERS = new ArrayList<>();
    public static final List<Restaurant> RESTAURANTS = new ArrayList<>();
    public static final List<Menu> MENUS = new ArrayList<>();
    public static final List<Order> ORDERS = new ArrayList<>();
    public static final List<OrderDetail> ORDER_DETAILS = new ArrayList<>();
    public static final Restaurant restaurant = new Restaurant(1, "RestoranBinar", "Medan", true);
    public static final User customer = new User(1, "admcust",  "admin", "admin@gmail.com", User.Role.CUSTOMER);

    public static void initRestaurants() {
        RESTAURANTS.add(restaurant);
    }

    public static void initCustomer() {
        USERS.add(customer);
    }

    public static void initMenu() {
        MENUS.add(new Menu("Nasi Goreng", Menu.FoodType.FOOD, 15000));
        MENUS.add(new Menu("Mie Goreng", Menu.FoodType.FOOD, 13000));
        MENUS.add(new Menu("Nasi + Ayam", Menu.FoodType.FOOD, 18000));
        MENUS.add(new Menu("Es Teh Manis", Menu.FoodType.DRINK, 3000));
        MENUS.add(new Menu("Es Jeruk", Menu.FoodType.DRINK, 5000));
    }
}
