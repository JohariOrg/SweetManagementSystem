package com.sweetmanagementsystem.management.user;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

import com.sweetmanagementsystem.user.UserAccount;
import com.sweetmanagementsystem.user.UserAccountService;

import static org.junit.Assert.assertNotNull;

public class UserAccountStepDefinitions {

    private UserAccountService userAccountService;
    private UserAccount userAccount;

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        userAccountService = new UserAccountService();
    }

    @When("the user registers with a username and password")
    public void the_user_registers_with_a_username_and_password() {
        userAccount = new UserAccount("user123", "password123");
        userAccountService.registerUser(userAccount);
    }

    @Then("the user should be registered successfully")
    public void the_user_should_be_registered_successfully() {
        UserAccount registeredUser = userAccountService.getUserAccount("user123");
        assertNotNull(registeredUser);
        System.out.println("User registered: " + registeredUser.getUsername());
    }

    @Given("the user has a registered account")
    public void the_user_has_a_registered_account() {
        userAccountService = new UserAccountService();
        userAccount = new UserAccount("user123", "password123");
        userAccountService.registerUser(userAccount);
    }

    @When("the user signs in with valid credentials")
    public void the_user_signs_in_with_valid_credentials() {
        boolean isLoggedIn = userAccountService.loginUser("user123", "password123");
        assertTrue(isLoggedIn);
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        System.out.println("User logged in: " + userAccount.getUsername());
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        userAccountService = new UserAccountService();
        userAccount = new UserAccount("user123", "password123");
        userAccountService.registerUser(userAccount);
        boolean isLoggedIn = userAccountService.loginUser("user123", "password123");
        assertTrue(isLoggedIn);
    }

    @When("the user shares a new dessert creation")
    public void the_user_shares_a_new_dessert_creation() {
        userAccount.shareDessertCreation("Chocolate Cake");
    }

    @Then("the dessert creation should be added successfully")
    public void the_dessert_creation_should_be_added_successfully() {
        assertNotNull(userAccount.getDessertCreations());
        assertTrue(userAccount.getDessertCreations().contains("Chocolate Cake"));
        System.out.println("Dessert shared: Chocolate Cake");
    }
}
