package org.binarfood.service;

import org.binarfood.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    void create(Restaurant restaurant);

    Restaurant getByChoice(int choice);
    List<Restaurant> getList();

    void clearList();
}
