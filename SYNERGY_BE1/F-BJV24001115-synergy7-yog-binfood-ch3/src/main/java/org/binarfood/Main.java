package org.binarfood;

import org.binarfood.controller.UserController;

import static org.binarfood.Data.*;


public class Main {
    public static void main(String[] args) {
        initCustomer();
        initRestaurants();
        initMenu();
//        CustomerView cv = new CustomerView();
//        cv.displayMainMenu();
        UserController uc = new UserController();
        uc.displayLoginMenu();
    }
}