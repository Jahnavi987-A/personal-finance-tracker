package com.example.personalFinanceTracker.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class FinanceController {
    
    @Autowired
    private FinanceService financeService;

    @PostMapping("/transactions")
    public void addTransactions(@RequestBody Finance finance){
        financeService.addTransactions(finance);
    }
    @GetMapping("/transactions")
    public List<Finance> getAllTransactions(){
        return financeService.getAllTransactions();
    }
    @GetMapping("/transactions/{id}")
    public Optional<Finance> getTransactionById(@PathVariable int id){
        return financeService.getTransactionById(id);
    }
    @DeleteMapping("/deletetransactions/{id}")
    public void deleteTransactionById(@PathVariable int id){
        financeService.deleteTransactionById(id);
    }
    @PutMapping("/updatealltransactions/{id}")
    public Finance updateAllTransactions(@PathVariable int id,@RequestBody Finance finance){
        return financeService.updateAllTransactions(id, finance);
    }
    @PatchMapping("/updatetransactions/{id}")
    public Finance updateTransactions(@PathVariable int id,@RequestBody Finance finance){
        return financeService.updateTransaction(id, finance);
    }
}

