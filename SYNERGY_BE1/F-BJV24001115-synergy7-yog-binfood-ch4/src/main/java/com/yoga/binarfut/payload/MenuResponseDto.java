package com.yoga.binarfut.payload;

import lombok.Data;

import java.time.LocalDateTime;
import com.yoga.binarfut.model.Menu.Type;
import java.util.UUID;

@Data
public class MenuResponseDto {
//    UUID menuId;
    UUID id;
    Integer price;
    String name;
    Type type;
    UUID Merchant;
}
