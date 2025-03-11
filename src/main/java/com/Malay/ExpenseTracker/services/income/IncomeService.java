package com.Malay.ExpenseTracker.services.income;

import com.Malay.ExpenseTracker.dto.IncomeDTO;
import com.Malay.ExpenseTracker.entity.Income;

import java.util.List;

public interface IncomeService {
    Income postIncome(IncomeDTO incomeDTO);

    List<IncomeDTO> getAllIncomes();

    Income updateIncome(Long id, IncomeDTO incomeDTO);

    IncomeDTO getIncomeById(Long id);

    void deleteIncomeById(Long id);
}
