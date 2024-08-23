package com.sweetmanagementsystem.admin;

import java.util.ArrayList;
import java.util.List;

public class ContentManagementService {

    private List<String> recipes;
    private List<String> posts;

    public ContentManagementService() {
        recipes = new ArrayList<>();
        posts = new ArrayList<>();
    }

    // Method to add a recipe
    public void addRecipe(String recipe) {
        recipes.add(recipe);
    }

    // Method to approve a recipe
    public boolean approveRecipe(String recipe) {
        return recipes.contains(recipe); // Approve if the recipe exists
    }

    // Method to reject a recipe
    public boolean rejectRecipe(String recipe) {
        return recipes.remove(recipe); // Reject by removing the recipe
    }

    // Method to add a post
    public void addPost(String post) {
        posts.add(post);
    }

    // Method to approve a post
    public boolean approvePost(String post) {
        return posts.contains(post); // Approve if the post exists
    }

    // Method to reject a post
    public boolean rejectPost(String post) {
        return posts.remove(post); // Reject by removing the post
    }

    // Retrieve all recipes for review
    public List<String> getAllRecipes() {
        return recipes;
    }

    // Retrieve all posts for review
    public List<String> getAllPosts() {
        return posts;
    }
}
