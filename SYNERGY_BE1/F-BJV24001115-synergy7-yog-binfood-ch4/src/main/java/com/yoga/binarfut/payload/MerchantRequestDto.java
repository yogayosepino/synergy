package com.yoga.binarfut.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class MerchantRequestDto {
    String name;
    String address;

    UUID owner;
}