package org.binarfood.controller;

import org.binarfood.model.Restaurant;
import org.binarfood.service.RestaurantService;
import org.binarfood.service.RestaurantServiceImpl;
import org.binarfood.view.RestaurantView;

import java.util.List;

public class RestaurantController {
    public void displayRestaurantList() {
        RestaurantService rs = new RestaurantServiceImpl();
        RestaurantView rv = new RestaurantView();

        List<Restaurant> restaurants = rs.getList();
        rv.displayRestaurantList(restaurants);
    }

}
