package org.binarfood.controller;

import java.util.List;

import org.binarfood.model.Menu;
import org.binarfood.view.MenuView;
import org.binarfood.service.MenuServiceImpl;
import org.binarfood.service.MenuService;


public class MenuController {
    public void displayMenuItemList() {
        MenuService mis = new MenuServiceImpl();
        MenuView miv = new MenuView();

        List<Menu> menu = mis.getList();
        miv.displayMenuItemList(menu);
    }

    public void displayMenuItem(int choice) {
        MenuService mis = new MenuServiceImpl();
        MenuView miv = new MenuView();

        Menu menuItem = mis.get(choice-1);

        miv.displayMenuItemHeader();
        miv.displayMenuItem(choice, menuItem);
    }
}
