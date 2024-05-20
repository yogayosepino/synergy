package com.yoga.binarfut.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderDetailRequestDto {
    int qty;
    UUID order;
    UUID menu;
}
