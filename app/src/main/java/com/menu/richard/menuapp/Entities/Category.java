package com.menu.richard.menuapp.Entities;

public enum Category {
    BREAKFAST("Frühstück"),
    MAIN_DISH("Hauptgericht"),
    SNACK("Snack");

    private final String full;

    Category(String full) {
        this.full = full;
    }

    public String getFull() {
        return full;
    }

    @Override
    public String toString() {
        return this.getFull();
    }
}
