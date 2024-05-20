package com.yoga.binarfut.service;

import com.yoga.binarfut.model.Menu;
import com.yoga.binarfut.model.User;
import com.yoga.binarfut.payload.MenuDto;
import com.yoga.binarfut.payload.MenuRequestDto;
import com.yoga.binarfut.payload.MenuResponseDto;

import java.util.List;
import java.util.UUID;

public interface MenuService {
    //create
    //notused
    Menu create(Menu menu);
    //notused
    Menu create(MenuResponseDto menuResponseDto);

    MenuResponseDto createMenu(MenuRequestDto menuRequestDto);

    //read
    List<Menu> getAll();

    //delete
    void softDeleteUser(UUID id);

    //update
    Menu patchMenu(UUID id, MenuDto menuDto);
}
