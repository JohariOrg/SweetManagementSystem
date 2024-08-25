package com.sweetmanagementsystem.management.admin;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.sweetmanagementsystem.management.Admin;
import com.sweetmanagementsystem.management.UserStatisticsService;

public class AdminReportStepDefinitions {

    private ReportService reportService;
    private UserStatisticsService userStatisticsService;
    private Admin admin;
    private String report;

    @Given("the admin is logged in for report")
    public void the_admin_is_logged_in_for_report() {
        admin = new Admin("adminUsername", "adminPassword");
        admin.login("adminUsername", "adminPassword");
        assertTrue(admin.isLoggedIn());
        reportService = new ReportService();
        userStatisticsService = new UserStatisticsService();
    }

    @When("the admin generates the profit report")
    public void the_admin_generates_the_profit_report() {
        // Simulate sales data
        reportService.addStoreProfit("Store1", 5000.0);
        reportService.addStoreProfit("Store2", 3500.0);
        report = reportService.generateProfitReport();
    }

    @Then("the report should display the total profits for each store")
    public void the_report_should_display_the_total_profits_for_each_store() {
        assertNotNull(report);
        System.out.println(report);
    }

    @When("the admin checks the best-selling store")
    public void the_admin_checks_the_best_selling_store() {
        reportService.addStoreProfit("Store1", 5000.0);
        reportService.addStoreProfit("Store2", 7000.0);
        String bestSellingStore = reportService.getBestSellingStore();
        System.out.println("Best-selling Store: " + bestSellingStore);
    }

    @Then("the best-selling store should be displayed")
    public void the_best_selling_store_should_be_displayed() {
        assertNotNull(reportService.getBestSellingStore());
    }

    @When("the admin generates city statistics")
    public void the_admin_generates_city_statistics() {
        userStatisticsService.addUserToCity("Nablus");
        userStatisticsService.addUserToCity("Jenin");
        userStatisticsService.addUserToCity("Nablus");
        report = userStatisticsService.generateCityStatisticsReport();
    }

    @Then("the report should display the number of users in each city")
    public void the_report_should_display_the_number_of_users_in_each_city() {
        assertNotNull(report);
        System.out.println(report);
    }
}
