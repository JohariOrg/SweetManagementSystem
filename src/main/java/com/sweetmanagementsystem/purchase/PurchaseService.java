package com.sweetmanagementsystem.purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseService {

    private List<Recipe> availableRecipes;

    public PurchaseService() {
        availableRecipes = new ArrayList<>();
    }

    // Add a recipe to the list
    public void addRecipe(Recipe recipe) {
        availableRecipes.add(recipe);
    }

    // Browse all available recipes
    public List<Recipe> browseRecipes() {
        return availableRecipes;
    }

    // Filter recipes based on dietary needs
    public List<Recipe> filterRecipes(boolean glutenFree, boolean vegan) {
        return availableRecipes.stream()
            .filter(recipe -> recipe.isGlutenFree() == glutenFree && recipe.isVegan() == vegan)
            .collect(Collectors.toList());
    }

    // Simulate purchasing a recipe
    public boolean purchaseRecipe(String recipeName) {
        for (Recipe recipe : availableRecipes) {
            if (recipe.getRecipeName().equals(recipeName)) {
                System.out.println("Purchased: " + recipeName);
                return true;
            }
        }
        return false;
    }
}
