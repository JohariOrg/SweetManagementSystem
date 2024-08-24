package com.sweetmanagementsystem.management.account;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

import com.sweetmanagementsystem.account.Account;
import com.sweetmanagementsystem.account.AccountManagementService;

import static org.junit.Assert.assertNotNull;

public class AccountManagementStepDefinitions {

    private AccountManagementService accountService;
    private Account account;

    @Given("the store owner is logged in for account management")
    public void the_store_owner_is_logged_in_for_account_management() {
        accountService = new AccountManagementService();
        account = new Account("storeOwner", "password123", "StoreName", "owner@store.com");
        accountService.addAccount(account);
    }

    @When("the store owner updates the business information")
    public void the_store_owner_updates_the_business_information() {
        boolean isUpdated = accountService.updateAccountInfo("storeOwner", "New Store Name", "newowner@store.com");
        assertTrue(isUpdated);
    }

    @Given("the supplier is logged in for account management")
    public void the_supplier_is_logged_in_for_account_management() {
        accountService = new AccountManagementService();
        account = new Account("supplier", "password456", "SupplierName", "supplier@materials.com");
        accountService.addAccount(account);
    }

    @When("the supplier updates the business information")
    public void the_supplier_updates_the_business_information() {
        boolean isUpdated = accountService.updateAccountInfo("supplier", "New Supplier Name", "newsupplier@materials.com");
        assertTrue(isUpdated);
    }

    @Then("the business information should be updated successfully")
    public void the_business_information_should_be_updated_successfully() {
        Account updatedAccount = accountService.getAccount(account.getUsername());

        // Debugging print statements
        if (updatedAccount == null) {
            System.out.println("Error: The account is null.");
        } else {
            System.out.println("Account found: " + updatedAccount.getUsername());
            System.out.println("Business Name: " + updatedAccount.getBusinessName());
            System.out.println("Contact Email: " + updatedAccount.getContactEmail());
        }

        // Continue with assertions
        assertNotNull("Account should not be null", updatedAccount);

        // Use different assertion based on which account is being tested
        if (account.getUsername().equals("storeOwner")) {
            assertTrue(updatedAccount.getBusinessName().equals("New Store Name"));
            assertTrue(updatedAccount.getContactEmail().equals("newowner@store.com"));
        } else if (account.getUsername().equals("supplier")) {
            assertTrue(updatedAccount.getBusinessName().equals("New Supplier Name"));
            assertTrue(updatedAccount.getContactEmail().equals("newsupplier@materials.com"));
        }
        
        System.out.println("Business information updated for: " + updatedAccount.getUsername());
    }


}
