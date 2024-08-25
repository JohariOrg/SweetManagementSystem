package com.sweetmanagementsystem.purchase;

public class Recipe {

    private String recipeName;
    private String ingredients;
    private boolean isGlutenFree;
    private boolean isVegan;

    public Recipe(String recipeName, String ingredients, boolean isGlutenFree, boolean isVegan) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.isGlutenFree = isGlutenFree;
        this.isVegan = isVegan;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public boolean isVegan() {
        return isVegan;
    }
}
