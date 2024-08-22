package com.sweetmanagementsystem.management.admin;

import com.sweetmanagementsystem.management.Admin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AdminStepDefinitions {

    private Admin admin;

    @Given("the admin is on the login page")
    public void the_admin_is_on_the_login_page() {
        // example of going to the login page
        admin = new Admin("admin", "killua");
    }

    @When("the admin enters valid credentials")
    public void the_admin_enters_valid_credentials() {
        // Simulate admin login with the correct credentials
        admin.login("adminUsername", "adminPassword");
    }

    @Then("the admin should be logged in successfully")
    public void the_admin_should_be_logged_in_successfully() {
        // Check that the admin is successfully logged in
        assert(admin.isLoggedIn());
    }

}
