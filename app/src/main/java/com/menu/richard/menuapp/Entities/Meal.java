package com.menu.richard.menuapp.Entities;

import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meal {
    private String pathToImage;
    private Category category;
    private String totalTime;
    private Map<Ingredient, Pair<Float, Unit>> ingredients = new HashMap<>();
    private List<String> instructions = new ArrayList<>();

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
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

    public Meal(String pathToImage, Category category, String totalTime, Map<Ingredient, Pair<Float, Unit>> ingredients, List<String> instructions) {
        this.pathToImage = pathToImage;
        this.category = category;
        this.totalTime = totalTime;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public void addIngredient(Ingredient ingredient, Pair<Float, Unit> amount) {
        this.ingredients.put(ingredient, amount);
    }

    public void addInstruction(String instruction) {
        this.instructions.add(instruction);
    }
}
