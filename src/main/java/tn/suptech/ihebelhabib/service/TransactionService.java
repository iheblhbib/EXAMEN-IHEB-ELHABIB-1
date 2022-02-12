package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Transaction;
import tn.suptech.ihebelhabib.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    public Transaction getOne(Long id){
        return transactionRepository.findById(id).get();
    }

    public Transaction add(Transaction transaction){
        return transactionRepository.save(transaction);
    }



}
