package com.sweetmanagementsystem.management.admin;


import java.util.HashMap;
import java.util.Map;

public class ReportService {

    // Data structure to store profits for each store
    private Map<String, Double> storeProfits;

    public ReportService() {
        storeProfits = new HashMap<>();
    }

    // Method to add sales data
    public void addStoreProfit(String storeName, double profit) {
        storeProfits.put(storeName, storeProfits.getOrDefault(storeName, 0.0) + profit);
    }

    // Method to generate a profit report
    public String generateProfitReport() {
        StringBuilder report = new StringBuilder("Store Profit Report:\n");
        for (Map.Entry<String, Double> entry : storeProfits.entrySet()) {
            report.append("Store: ").append(entry.getKey())
                  .append(" | Total Profit: $").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }

    // Method to identify the best-selling store
    public String getBestSellingStore() {
        double maxProfit = 0.0;
        String bestStore = null;
        for (Map.Entry<String, Double> entry : storeProfits.entrySet()) {
            if (entry.getValue() > maxProfit) {
                maxProfit = entry.getValue();
                bestStore = entry.getKey();
            }
        }
        return bestStore;
    }
}
