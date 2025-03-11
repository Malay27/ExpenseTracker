package com.Malay.ExpenseTracker.dto;


import com.Malay.ExpenseTracker.entity.Expense;
import com.Malay.ExpenseTracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {

    public List<Expense> expenseList;

    public List<Income> incomeList;
}
