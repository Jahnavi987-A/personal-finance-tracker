package com.example.personalFinanceTracker.dashboard;


import java.util.Map;
import java.time.Month;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.personalFinanceTracker.FinanceRepository;

@Service
public class DashboardService {

    @Autowired
    private FinanceRepository financeRepository;

    public Dashboard getDashboardData(int month) {

        Dashboard response = new Dashboard();

        Double income = financeRepository.getTotalIncomeByMonth(month);
        Double expense = financeRepository.getTotalExpenseByMonth(month);

        double safeIncome = income != null ? income : 0.0;
        double safeExpense = expense != null ? expense : 0.0;

        response.setTotalIncome(safeIncome);
        response.setTotalExpense(safeExpense);
        response.setSavings(safeIncome - safeExpense);

    
        Map<String, Double> categoryMap = new HashMap<>();
        List<Object[]> categoryData =
                financeRepository.getCategoryExpensesByMonth(month);

        for (Object[] row : categoryData) {
            categoryMap.put((String) row[0], ((Number) row[1]).doubleValue());
        }
        response.setCategoryExpenses(categoryMap);

        
        Map<String, Double> monthlyMap = new LinkedHashMap<>();
        List<Object[]> monthlyData =
                financeRepository.getMonthlyExpenses();

        for (Object[] row : monthlyData) {
            int monthNumber = ((Number) row[0]).intValue();
            double amount = ((Number) row[1]).doubleValue();

            if (monthNumber >= 1 && monthNumber <= 12) {
                monthlyMap.put(getMonthName(monthNumber), amount);
            }
        }

        response.setMonthlyExpenses(monthlyMap);

        return response;
    }

    private String getMonthName(int month) {
        return Month.of(month).name().substring(0, 3);
    }
}
