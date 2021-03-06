package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.domain.Compte;
import tn.suptech.ihebelhabib.domain.Transaction;
import tn.suptech.ihebelhabib.repository.CompteRepository;
import tn.suptech.ihebelhabib.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CompteRepository compteRepository;

    public List<Transaction> getAll(){
        return transactionRepository.findAll();
    }

    public Transaction getOne(Long id){
        return transactionRepository.findById(id).get();
    }

    public Transaction add(Transaction transaction){

        Compte comptedesinataire = compteRepository.findByRib(transaction.getDistinataire());

        Compte comptesource = compteRepository.findByRib(transaction.getSource());

        comptesource.setMontant(comptesource.getMontant() - transaction.getMontant() - comptesource.getCout());

        comptedesinataire.setMontant( comptedesinataire.getMontant() + transaction.getMontant() - comptedesinataire.getCout());

        return transactionRepository.save(transaction);
    }



}
