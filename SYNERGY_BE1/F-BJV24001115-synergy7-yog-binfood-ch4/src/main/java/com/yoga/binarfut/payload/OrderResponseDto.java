package com.yoga.binarfut.payload;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OrderResponseDto {
    UUID id;
//    UUID orderDetailId;
    LocalDateTime orderTime;
    String name;
    String destination;
    boolean statusOrder;
}
