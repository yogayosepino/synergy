package com.yoga.binarfut.payload;

import lombok.Data;

import java.util.UUID;

@Data
public class MerchantResponseDto {
    UUID id;
    String name;
//    boolean open;
}