package com.Malay.ExpenseTracker.controller;


import com.Malay.ExpenseTracker.dto.IncomeDTO;
import com.Malay.ExpenseTracker.entity.Income;
import com.Malay.ExpenseTracker.services.income.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<?> postIncome(@RequestBody IncomeDTO incomeDTO){
        Income createdIncome = incomeService.postIncome(incomeDTO);
        if(createdIncome != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllIncomes(){
        return ResponseEntity.ok(incomeService.getAllIncomes());
    }
}
