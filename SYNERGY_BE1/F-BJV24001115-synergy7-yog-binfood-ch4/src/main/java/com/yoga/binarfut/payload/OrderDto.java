package com.yoga.binarfut.payload;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OrderDto {
//    UUID id;
    LocalDateTime orderTime;
    String destination;
    boolean statusOrder;
}
