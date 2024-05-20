package com.yoga.binarfut.payload;

import lombok.Data;
import com.yoga.binarfut.model.Menu.Type;

import java.util.UUID;

@Data
public class MenuRequestDto {
    String name;
    Integer price;

    Type type;
    UUID merchant;
}
