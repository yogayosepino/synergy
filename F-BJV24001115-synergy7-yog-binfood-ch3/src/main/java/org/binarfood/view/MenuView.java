package org.binarfood.view;

import java.util.List;

import org.binarfood.model.Menu;

public class MenuView {
    public void displayMenuItemHeader() {

        System.out.println("      Menu      |   Price     ");
    }

    public void displayMenuItem(int num, Menu menuItem) {
//        System.out.println(
//                (num),
//                menuItem.getName(),
//                menuItem.getPrice()
//        );
        System.out.println(num + " " + menuItem.getName() + "  " + menuItem.getPrice());
    }

    public void displayMenuItemList(List<Menu> menu) {
        displayMenuItemHeader();
        for (int i = 0; i<menu.size(); i++) {
            Menu menuItem = menu.get(i);
            displayMenuItem(i+1, menuItem);
        }
    }
}

