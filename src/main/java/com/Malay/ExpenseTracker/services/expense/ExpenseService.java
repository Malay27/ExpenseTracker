package com.Malay.ExpenseTracker.services.expense;

import com.Malay.ExpenseTracker.dto.ExpenseDTO;
import com.Malay.ExpenseTracker.entity.Expense;

import java.util.List;

public interface ExpenseService {
    Expense postExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
}
