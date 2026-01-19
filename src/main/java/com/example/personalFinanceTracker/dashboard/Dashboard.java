package com.example.personalFinanceTracker.dashboard;

import java.util.Map;

public class Dashboard {

    private Double totalIncome;
    private Double totalExpense;
    private Double savings;

    private Map<String, Double> categoryExpenses;
    private Map<String, Double> monthlyExpenses;

    public Double getTotalIncome() {
        return totalIncome;
    }
    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }
    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Double getSavings() {
        return savings;
    }
    public void setSavings(Double savings) {
        this.savings = savings;
    }

    public Map<String, Double> getCategoryExpenses() {
        return categoryExpenses;
    }
    public void setCategoryExpenses(Map<String, Double> categoryExpenses) {
        this.categoryExpenses = categoryExpenses;
    }

    public Map<String, Double> getMonthlyExpenses() {
        return monthlyExpenses;
    }
    public void setMonthlyExpenses(Map<String, Double> monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    }
}
