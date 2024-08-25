package com.sweetmanagementsystem.account;

public class Account {

    private String username;
    private String password;
    private String businessName;
    private String contactEmail;

    public Account(String username, String password, String businessName, String contactEmail) {
        this.username = username;
        this.password = password;
        this.businessName = businessName;
        this.contactEmail = contactEmail;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
