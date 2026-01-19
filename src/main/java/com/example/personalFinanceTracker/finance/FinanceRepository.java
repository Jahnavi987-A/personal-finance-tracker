package com.example.personalFinanceTracker.finance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface FinanceRepository extends JpaRepository<Finance,Integer>{
    
     // Total income for a month
    @Query("SELECT COALESCE(SUM(f.amount), 0) FROM Finance f " +
           "WHERE f.type = 'INCOME' AND MONTH(f.date) = :month")
    Double getTotalIncomeByMonth(int month);

    // Total expense for a month
    @Query("SELECT COALESCE(SUM(f.amount), 0) FROM Finance f " +
           "WHERE f.type = 'EXPENSE' AND MONTH(f.date) = :month")
    Double getTotalExpenseByMonth(int month);

    // Category-wise expense for a month
    @Query("SELECT f.category, SUM(f.amount) FROM Finance f " +
           "WHERE f.type = 'EXPENSE' AND MONTH(f.date) = :month " +
           "GROUP BY f.category")
    List<Object[]> getCategoryExpensesByMonth(int month);

    // Month-wise expenses (for bar chart)
    @Query("SELECT MONTH(f.date), SUM(f.amount) FROM Finance f " +
           "WHERE f.type = 'EXPENSE' GROUP BY MONTH(f.date)")
    List<Object[]> getMonthlyExpenses();
}
