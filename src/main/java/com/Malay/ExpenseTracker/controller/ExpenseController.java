package com.Malay.ExpenseTracker.controller;


import com.Malay.ExpenseTracker.dto.ExpenseDTO;
import com.Malay.ExpenseTracker.entity.Expense;
import com.Malay.ExpenseTracker.services.expense.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/expense")
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    private ResponseEntity<?> postExpense(@RequestBody ExpenseDTO expenseDTO){
        Expense createExpense = expenseService.postExpense(expenseDTO);
        if(createExpense != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createExpense);
        }else{
            return ResponseEntity.status((HttpStatus.BAD_REQUEST)).build();
        }
    }
}
