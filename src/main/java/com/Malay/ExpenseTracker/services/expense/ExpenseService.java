package com.Malay.ExpenseTracker.services.expense;

import com.Malay.ExpenseTracker.dto.ExpenseDTO;
import com.Malay.ExpenseTracker.entity.Expense;

public interface ExpenseService {
    Expense postExpense(ExpenseDTO expenseDTO);
}
