package com.Malay.ExpenseTracker.dto;


import com.Malay.ExpenseTracker.entity.Expense;
import com.Malay.ExpenseTracker.entity.Income;
import lombok.Data;

@Data
public class StatsDTO {

    private Double income;

    private Double expense;

    private Income latestIncome;

    private Expense latestExpense;

    private Double balance;

    private Double minIncome;

    private Double maxIncome;

    private Double minExpense
            ;
    private Double maxExpense;
}
