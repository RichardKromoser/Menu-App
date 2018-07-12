package com.menu.richard.menuapp.Entities;

public class Amount {
    private float amount;
    private String units;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Amount(float amount, String units) {
        this.amount = amount;
        this.units = units;
    }
}
