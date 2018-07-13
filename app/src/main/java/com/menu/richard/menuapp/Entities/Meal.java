package com.menu.richard.menuapp.Entities;

import android.graphics.Bitmap;
import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meal {
    private Bitmap image;
    private Category category;
    private String name;
    private String totalTime;
    private Map<Ingredient, Pair<Float, Unit>> ingredients = new HashMap<>();
    private List<String> instructions = new ArrayList<>();

    public Meal(Bitmap image, Category category, String name, String totalTime, Map<Ingredient, Pair<Float, Unit>> ingredients, List<String> instructions) {
        this.image = image;
        this.category = category;
        this.name = name;
        this.totalTime = totalTime;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Map<Ingredient, Pair<Float, Unit>> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Ingredient, Pair<Float, Unit>> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public void addIngredient(Ingredient ingredient, Pair<Float, Unit> amount) {
        this.ingredients.put(ingredient, amount);
    }

    public void addInstruction(String instruction) {
        this.instructions.add(instruction);
    }
}
