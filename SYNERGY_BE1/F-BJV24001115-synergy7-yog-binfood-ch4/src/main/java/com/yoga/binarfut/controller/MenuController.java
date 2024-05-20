package com.yoga.binarfut.controller;


import com.yoga.binarfut.model.Menu;
import com.yoga.binarfut.model.Merchant;
import com.yoga.binarfut.model.User;
import com.yoga.binarfut.payload.MenuDto;
import com.yoga.binarfut.payload.MenuRequestDto;
import com.yoga.binarfut.payload.MenuResponseDto;
import com.yoga.binarfut.payload.UserDto;
import com.yoga.binarfut.service.MenuService;
import com.yoga.binarfut.service.MerchantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MerchantService merchantService;

    //create
    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createMenu(@RequestBody MenuRequestDto menuRequestDto){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
            MenuResponseDto responseDto = menuService.createMenu(menuRequestDto);

        data.put("menu",responseDto);
        response.put("data",data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //read
    @GetMapping("read")
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
//        cara 1
//        data.put("cinemas", cinemaService.getCinemaList());

        List<Menu> menuList = menuService.getAll();
        List<MenuDto> menuDtoList = menuList
                .stream()
                .map(menu -> modelMapper.map(menu, MenuDto.class))
                .toList();
        data.put("menu", menuDtoList);

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //update
    @PatchMapping("{id}")
    public ResponseEntity<Menu> updateUser(@PathVariable UUID id, @RequestBody MenuDto menuDto) {
        Menu patchMenu = menuService.patchMenu(id, menuDto);
        return ResponseEntity.ok(patchMenu);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable UUID id) {
        menuService.softDeleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
