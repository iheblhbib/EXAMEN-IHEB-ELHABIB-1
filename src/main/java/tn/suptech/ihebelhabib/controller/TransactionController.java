package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.domain.Transaction;
import tn.suptech.ihebelhabib.enums.SensTransaction;
import tn.suptech.ihebelhabib.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping(path = "/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    Logger logger = LoggerFactory.getLogger(TransactionController.class);


    @PostMapping(path = "/add")
    public Transaction createTransaction(@RequestBody Transaction transaction){
        logger.info("ajout une transaction");

        SensTransaction sensTransaction = transaction.getSens();
        double montant = transaction.getMontant();
        return transactionService.add(transaction);
    }


    @GetMapping(path = "/transaction/{id}")
    public Transaction getTransaction(@PathVariable Long id){
        logger.info("obtenir une transaction");
        return transactionService.getOne(id);
    }

    @GetMapping(path = "/")
    public List<Transaction> getTransaction(){
        logger.info("obtenir les transactions");
        return transactionService.getAll();
    }
}
