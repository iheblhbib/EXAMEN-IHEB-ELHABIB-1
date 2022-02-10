package tn.suptech.ihebelhabib.service;

import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Transaction;
import tn.suptech.ihebelhabib.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    public Transaction getOne(Long id){
        return transactionRepository.findById(id).get();
    }

    public Transaction add(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public Transaction update(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public Transaction delete(Long id){
        Transaction deletedTransaction = this.getOne(id);
        transactionRepository.delete(deletedTransaction);
        return deletedTransaction;
    }
}
