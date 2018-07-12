package com.menu.richard.menuapp.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meal {
    private String pathToImage;
    private Category category;
    private Map<Ingredient, Amount> ingredients = new HashMap<>();
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

    public Map<Ingredient, Amount> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Ingredient, Amount> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public Meal(String pathToImage, Category category, Map<Ingredient, Amount> ingredients, List<String> instructions) {
        this.pathToImage = pathToImage;
        this.category = category;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public void addIngredient(Ingredient ingredient, Amount amount) {
        this.ingredients.put(ingredient, amount);
    }

    public void addInstruction(String instruction) {
        this.instructions.add(instruction);
    }
}
