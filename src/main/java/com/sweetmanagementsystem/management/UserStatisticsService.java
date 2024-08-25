package com.sweetmanagementsystem.management;

import java.util.HashMap;
import java.util.Map;

public class UserStatisticsService {

    // Data structure to store user statistics by city
    private Map<String, Integer> userStatisticsByCity;

    public UserStatisticsService() {
        userStatisticsByCity = new HashMap<>();
    }

    // Method to add user data based on the city
    public void addUserToCity(String city) {
        userStatisticsByCity.put(city, userStatisticsByCity.getOrDefault(city, 0) + 1);
    }

    // Method to generate statistics report by city
    public String generateCityStatisticsReport() {
        StringBuilder report = new StringBuilder("User Statistics by City:\n");
        for (Map.Entry<String, Integer> entry : userStatisticsByCity.entrySet()) {
            report.append("City: ").append(entry.getKey())
                  .append(" | Users: ").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}
