package com.sweetmanagementsystem.user;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {

    private String username;
    private String password;
    private List<String> dessertCreations;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.dessertCreations = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getDessertCreations() {
        return dessertCreations;
    }

    public void shareDessertCreation(String dessert) {
        dessertCreations.add(dessert);
    }

}
