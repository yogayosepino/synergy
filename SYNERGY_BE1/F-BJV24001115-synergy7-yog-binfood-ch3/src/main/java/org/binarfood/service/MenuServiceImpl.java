package org.binarfood.service;

import org.binarfood.Data;
import org.binarfood.model.Menu;
import org.binarfood.exception.*;

import java.util.List;

public class MenuServiceImpl implements MenuService {
    @Override
    public Menu get(int choice) {
        if (choice < 0 || choice >= Data.MENUS.size()) {
            throw new IndexOutOfBoundsException("Pilihan invalid: " + choice);
        }

        Menu menuItem = Data.MENUS.get(choice);
        if (menuItem == null) {
            throw new FindingErrorMenuException("MenuItem tidak ditemukan: " + choice);
        }

        return menuItem;
    }

    @Override
    public List<Menu> getList() {
        return Data.MENUS;
    }
}
