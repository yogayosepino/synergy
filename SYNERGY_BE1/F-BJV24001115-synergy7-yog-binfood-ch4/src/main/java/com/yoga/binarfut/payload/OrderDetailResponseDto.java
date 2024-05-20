package com.yoga.binarfut.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderDetailResponseDto {
    UUID id;
    int qty;
    int price;

    UUID order;
    UUID menu;

}
