package com.Malay.ExpenseTracker.controller;


import com.Malay.ExpenseTracker.dto.ExpenseDTO;
import com.Malay.ExpenseTracker.entity.Expense;
import com.Malay.ExpenseTracker.services.expense.ExpenseService;
import jakarta.persistence.EntityNotFoundException;
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

    @GetMapping("/all")
    private ResponseEntity<?> getAllExpense(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getExpenseById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(expenseService.getExpenseById(id));
        }catch (EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Somethings went wrong");
        }
    }
}
