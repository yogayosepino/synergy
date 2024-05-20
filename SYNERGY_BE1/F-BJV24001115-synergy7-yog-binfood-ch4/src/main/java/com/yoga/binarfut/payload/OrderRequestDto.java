package com.yoga.binarfut.payload;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class OrderRequestDto {
    String destination;

    UUID customer;
    UUID merchant;

}
