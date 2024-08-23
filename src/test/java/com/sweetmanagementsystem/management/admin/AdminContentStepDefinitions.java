package com.sweetmanagementsystem.management.admin;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.sweetmanagementsystem.admin.ContentManagementService;
import com.sweetmanagementsystem.admin.FeedbackService;
import com.sweetmanagementsystem.management.Admin;

public class AdminContentStepDefinitions {

    private Admin admin;
    private ContentManagementService contentService;
    private FeedbackService feedbackService;
    private String recipe;
    private String post;

    @Given("the admin is logged in for content management")
    public void the_admin_is_logged_in_for_content_management() {
        admin = new Admin("adminUsername", "adminPassword");
        admin.login("adminUsername", "adminPassword");
        assertTrue(admin.isLoggedIn());
        contentService = new ContentManagementService();
        feedbackService = new FeedbackService();
    }

    @When("the admin approves a recipe")
    public void the_admin_approves_a_recipe() {
        recipe = "Chocolate Cake";
        contentService.addRecipe(recipe);
        boolean isApproved = contentService.approveRecipe(recipe);
        assertTrue(isApproved);
    }

    @Then("the recipe should be marked as approved")
    public void the_recipe_should_be_marked_as_approved() {
        System.out.println("Recipe approved: " + recipe);
    }

    @When("the admin rejects a recipe")
    public void the_admin_rejects_a_recipe() {
        recipe = "Vanilla Cake";
        contentService.addRecipe(recipe);
        boolean isRejected = contentService.rejectRecipe(recipe);
        assertTrue(isRejected);
    }

    @Then("the recipe should be removed from the system")
    public void the_recipe_should_be_removed_from_the_system() {
        List<String> remainingRecipes = contentService.getAllRecipes();
        assertTrue(!remainingRecipes.contains(recipe));
        System.out.println("Recipe rejected and removed: " + recipe);
    }

    @When("the admin views all feedback")
    public void the_admin_views_all_feedback() {
        feedbackService.addFeedback("Great product!");
        List<String> feedbackList = feedbackService.getAllFeedback();
        assertNotNull(feedbackList);
        feedbackList.forEach(System.out::println);
    }

    @Then("the feedback should be displayed")
    public void the_feedback_should_be_displayed() {
        // Feedback was printed in the previous step
    }
}
