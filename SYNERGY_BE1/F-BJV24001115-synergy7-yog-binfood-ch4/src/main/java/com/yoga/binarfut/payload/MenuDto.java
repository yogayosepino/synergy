package com.yoga.binarfut.payload;


import lombok.Data;
import com.yoga.binarfut.model.Menu.Type;

@Data
public class MenuDto {
    String name;
    Integer price;
    Type type;

}
