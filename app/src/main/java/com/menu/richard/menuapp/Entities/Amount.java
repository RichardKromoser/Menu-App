package com.menu.richard.menuapp.Entities;

public class Amount {
    private float amount;
    private String unit;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnits(String unit) {
        this.unit = unit;
    }

    public Amount(float amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }
}
