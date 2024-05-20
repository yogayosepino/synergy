package org.binarfood.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Menu {
    private String name;
    private FoodType foodType;
    private int price;
//    private final HashMap<String,Integer> available;

    public enum FoodType{
        FOOD, DRINK
    }

    public Menu(String name, FoodType foodType, int price){
        this.name = name;
        this.foodType = foodType;
        this.price = price;
    }

}
