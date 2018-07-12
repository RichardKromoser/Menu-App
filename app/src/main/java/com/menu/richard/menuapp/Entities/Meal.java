package com.menu.richard.menuapp.Entities;

import com.menu.richard.menuapp.NoEntities.Category;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private String pathToImage;
    private Category category;
    private List<Ingredient> ingredients = new ArrayList<>();
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public Meal(String pathToImage, Category category, List<Ingredient> ingredients, List<String> instructions) {
        this.pathToImage = pathToImage;
        this.category = category;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void addInstruction(String instruction) {
        this.instructions.add(instruction);
    }
}
