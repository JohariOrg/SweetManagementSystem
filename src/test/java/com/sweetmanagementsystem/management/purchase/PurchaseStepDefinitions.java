package com.sweetmanagementsystem.management.purchase;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.sweetmanagementsystem.purchase.PurchaseService;
import com.sweetmanagementsystem.purchase.Recipe;

public class PurchaseStepDefinitions {

    private PurchaseService purchaseService;
    private List<Recipe> availableRecipes;
    private List<Recipe> filteredRecipes;
    private boolean purchaseSuccess;

    @Given("the user is on the recipe browsing page")
    public void the_user_is_on_the_recipe_browsing_page() {
        purchaseService = new PurchaseService();
        purchaseService.addRecipe(new Recipe("Chocolate Cake", "Flour, Cocoa, Sugar", false, false));
        purchaseService.addRecipe(new Recipe("Vegan Brownie", "Cocoa, Almond Flour, Sugar", true, true));
        purchaseService.addRecipe(new Recipe("Gluten-Free Cookie", "Rice Flour, Sugar, Butter", true, false));
    }

    @When("the user views all available recipes")
    public void the_user_views_all_available_recipes() {
        availableRecipes = purchaseService.browseRecipes();
    }

    @Then("the user should see a list of recipes")
    public void the_user_should_see_a_list_of_recipes() {
        assertNotNull(availableRecipes);
        System.out.println("Available Recipes:");
        for (Recipe recipe : availableRecipes) {
            System.out.println(recipe.getRecipeName());
        }
    }

    @Given("the user has dietary preferences")
    public void the_user_has_dietary_preferences() {
        purchaseService = new PurchaseService();
        purchaseService.addRecipe(new Recipe("Chocolate Cake", "Flour, Cocoa, Sugar", false, false));
        purchaseService.addRecipe(new Recipe("Vegan Brownie", "Cocoa, Almond Flour, Sugar", true, true));
        purchaseService.addRecipe(new Recipe("Gluten-Free Cookie", "Rice Flour, Sugar, Butter", true, false));
    }

    @When("the user filters for gluten-free and vegan recipes")
    public void the_user_filters_for_gluten_free_and_vegan_recipes() {
        filteredRecipes = purchaseService.filterRecipes(true, true);
    }

    @Then("the user should see a list of filtered recipes")
    public void the_user_should_see_a_list_of_filtered_recipes() {
        assertNotNull(filteredRecipes);
        System.out.println("Filtered Recipes:");
        for (Recipe recipe : filteredRecipes) {
            System.out.println(recipe.getRecipeName());
        }
    }

    @Given("the user has selected a recipe")
    public void the_user_has_selected_a_recipe() {
        purchaseService = new PurchaseService();
        purchaseService.addRecipe(new Recipe("Chocolate Cake", "Flour, Cocoa, Sugar", false, false));
    }

    @When("the user completes the purchase")
    public void the_user_completes_the_purchase() {
        purchaseSuccess = purchaseService.purchaseRecipe("Chocolate Cake");
    }

    @Then("the recipe should be purchased successfully")
    public void the_recipe_should_be_purchased_successfully() {
        assertTrue(purchaseSuccess);
        System.out.println("Purchase successful!");
    }
}
