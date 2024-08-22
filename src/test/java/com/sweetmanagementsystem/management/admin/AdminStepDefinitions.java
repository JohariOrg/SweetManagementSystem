package com.sweetmanagementsystem.management.admin;

import com.sweetmanagementsystem.management.Admin;
import com.sweetmanagementsystem.management.StoreOwner;
import com.sweetmanagementsystem.management.Supplier;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertNotNull;


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

    @Given("the admin is logged in")
    public void the_admin_is_logged_in() {
        // Simulate the admin already being logged in
        admin = new Admin("adminUsername", "adminPassword");
        admin.login("adminUsername", "adminPassword");
    }

    @When("the admin adds a new store owner")
    public void the_admin_adds_a_new_store_owner() {
        // Admin adds a new store owner
        StoreOwner storeOwner = new StoreOwner("storeOwner1", "password");
        admin.addUser(storeOwner);
    }

    @Then("the store owner should be added successfully")
    public void the_store_owner_should_be_added_successfully() {
        // Verify the store owner was successfully added
        assert(admin.getUser("storeOwner1") != null);
    }


    @When("the admin adds a new raw material supplier")
    public void the_admin_adds_a_new_raw_material_supplier() {
        // Admin adds a new supplier
        Supplier supplier = new Supplier("supplier1", "password");
        admin.addUser(supplier);
    }

    @Then("the supplier should be added successfully")
    public void the_supplier_should_be_added_successfully() {
        // Verify that the supplier was added successfully
        assertNotNull(admin.getUser("supplier1"));
    }
}
