package com.menu.richard.menuapp.Entities;

import android.graphics.Bitmap;
import android.util.Pair;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meal {
    private Bitmap image;
    private Category category;
    private String name;
    private String totalTime;
    private List<String> ingredients= new ArrayList<>();
    private List<String> instructions = new ArrayList<>();

    public Meal(Bitmap image, Category category, String name, String totalTime, String ingredients, String instructions) {
        this.image = image;
        this.category = category;
        this.name = name;
        this.totalTime = totalTime;
        StringToList(ingredients, this.ingredients);
        StringToList(instructions, this.instructions);
    }

    public Meal(Bitmap image, Category category, String name, String totalTime) {
        this.image = image;
        this.category = category;
        this.name = name;
        this.totalTime = totalTime;
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

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
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

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public void addInstruction(String instruction) {
        this.instructions.add(instruction);
    }

    private void StringToList(String listAsString, List<String> listToAdd) {
        if (listAsString != null && !listAsString.isEmpty()) {
            String[] ingredientsAsArray = listAsString.split("\\|");

            listToAdd.addAll(Arrays.asList(ingredientsAsArray));
        } else {
            listToAdd.add("Kein Eintrag vorhanden");
        }
    }
}
