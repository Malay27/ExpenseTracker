package com.Malay.ExpenseTracker.services.stats;


import com.Malay.ExpenseTracker.dto.GraphDTO;
import com.Malay.ExpenseTracker.dto.StatsDTO;
import com.Malay.ExpenseTracker.entity.Expense;
import com.Malay.ExpenseTracker.entity.Income;
import com.Malay.ExpenseTracker.repository.ExpenseRepository;
import com.Malay.ExpenseTracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final IncomeRepository incomeRepository;

    private final ExpenseRepository expenseRepository;

    public GraphDTO getChartData(){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);

        GraphDTO graphDTO= new GraphDTO();
        graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate,endDate));
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate,endDate));

        return graphDTO;
    }

    public StatsDTO getStats(){
        Double totalIncome = incomeRepository.sumAllAmounts();
        Double totalExpense =  expenseRepository.sumAllAmounts();

        Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> optionalExpense = expenseRepository.findFirstByOrderByDateDesc();

        StatsDTO statsDTO = new StatsDTO();
        statsDTO.setExpense(totalExpense);
        statsDTO.setIncome(totalIncome);

        optionalIncome.ifPresent(statsDTO::setLatestIncome);
        optionalExpense.ifPresent(statsDTO::setLatestExpense);

        statsDTO.setBalance(totalIncome-totalExpense);

        List<Income> incomeList = incomeRepository.findAll();
        List<Expense> expenseList = expenseRepository.findAll();

        OptionalDouble minIncome = incomeList.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();

        OptionalDouble minExpense = expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();

        statsDTO.setMinIncome(minIncome.isPresent()?minIncome.getAsDouble():null);
        statsDTO.setMaxIncome(maxIncome.isPresent()?maxIncome.getAsDouble():null);

        statsDTO.setMinExpense(minExpense.isPresent()?minExpense.getAsDouble():null);
        statsDTO.setMaxExpense(maxExpense.isPresent()?maxExpense.getAsDouble():null);

        return statsDTO;
    }
}
