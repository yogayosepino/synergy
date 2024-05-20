package org.binarfood.service;

import java.util.List;

import org.binarfood.model.Menu;

public interface MenuService {
    Menu get(int choice);
    List<Menu> getList();
}
