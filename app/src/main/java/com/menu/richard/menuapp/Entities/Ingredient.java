package com.menu.richard.menuapp.Entities;

public class Ingredient {
    private String name;
    private String amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Ingredient(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }
}