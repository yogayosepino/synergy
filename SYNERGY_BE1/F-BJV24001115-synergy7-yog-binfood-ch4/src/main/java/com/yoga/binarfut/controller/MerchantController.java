package com.yoga.binarfut.controller;


import com.yoga.binarfut.model.Menu;
import com.yoga.binarfut.model.Merchant;
import com.yoga.binarfut.model.User;
import com.yoga.binarfut.payload.*;
import com.yoga.binarfut.service.MerchantService;
import com.yoga.binarfut.service.UserService;
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
@RequestMapping("merchant")
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    //create
    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createMenu(@RequestBody MerchantRequestDto merchantRequestDto) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        MerchantResponseDto merchantResponseDto = merchantService.create(merchantRequestDto);

        data.put("menu", merchantResponseDto);
        response.put("data", data);

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


        List<Merchant> merchantList = merchantService.getAll();
        List<MerchantDto> merchantDtoList = merchantList
                .stream()
                .map(merchant -> modelMapper.map(merchant, MerchantDto.class))
                .toList();
        data.put("merchant", merchantDtoList);

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //update
    @PatchMapping("{id}")
    public ResponseEntity<Merchant> updateUser(@PathVariable UUID id, @RequestBody MerchantDto merchantDto) {
        Merchant patchMerchant = merchantService.patchMerchant(id, merchantDto);
        return ResponseEntity.ok(patchMerchant);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable UUID id) {
        merchantService.softDeleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
