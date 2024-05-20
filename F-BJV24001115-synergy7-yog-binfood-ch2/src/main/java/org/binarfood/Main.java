package org.binarfood;

import org.binarfood.view.CustomerView;

import static org.binarfood.Data.initializeMenu;

public class Main {
    public static void main(String[] args) {

        initializeMenu();

        CustomerView cv = new CustomerView();
        cv.displayMainMenu();
    }
}