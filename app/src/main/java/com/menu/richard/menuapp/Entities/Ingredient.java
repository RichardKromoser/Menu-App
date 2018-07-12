package com.menu.richard.menuapp.Entities;

public class Ingredient {
    private String name;
    private FoodType foodType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Ingredient(String name, FoodType foodType) {
        this.name = name;
        this.foodType = foodType;
    }
}
