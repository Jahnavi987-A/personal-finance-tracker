package com.example.personalFinanceTracker.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FinanceService {

    @Autowired
    private FinanceRepository financeRepository;

    public void addTransactions(Finance finance){
        financeRepository.save(finance);
    }
    public List<Finance> getAllTransactions(){
        return financeRepository.findAll();
    }
    public Optional<Finance> getTransactionById(int id){
        return financeRepository.findById(id);
    }
    public void deleteTransactionById(int id){
        financeRepository.deleteById(id);
    }
    public Finance updateTransaction(int id,Finance finance){
        Finance existingTransaction = getTransactionById(id).orElseThrow(()->new RuntimeException("Transaction not found")); 
        if(finance.getAmount()!=null){
            existingTransaction.setAmount(finance.getAmount());
        }
        if(finance.getType()!=null){
            existingTransaction.setType(finance.getType());
        }
        if(finance.getDate()!=null){
            existingTransaction.setDate(finance.getDate());
        }
        if(finance.getCategory()!=null){
            existingTransaction.setCategory(finance.getCategory());
        }
        financeRepository.save(existingTransaction);
        return existingTransaction;
    }
    public Finance updateAllTransactions(int id,Finance finance){
        Finance existingTransaction = getTransactionById(id).orElseThrow(()->new RuntimeException("Transaction is not found"));
        existingTransaction.setAmount(finance.getAmount());
        existingTransaction.setType(finance.getType());
        existingTransaction.setCategory(finance.getCategory());
        existingTransaction.setDate(finance.getDate());
        financeRepository.save(existingTransaction);
        return existingTransaction;
    }
    
}
