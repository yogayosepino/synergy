package org.binarfood.view;

import org.binarfood.model.Restaurant;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

public class RestaurantView {
    public void displayRestaurantList(List<Restaurant> restaurants) {
        AtomicInteger index = new AtomicInteger(1);
        restaurants.forEach(restaurant -> displayRestaurant(index.getAndIncrement(), restaurant));
    }

    public void displayRestaurant(int num, Restaurant restaurant) {
        System.out.println(num + ". " + restaurant.getName());
    }
}
