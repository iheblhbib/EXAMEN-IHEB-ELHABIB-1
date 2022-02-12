package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Transaction;
import tn.suptech.ihebelhabib.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping(path = "/transaction")
public class TransactionController {

    private TransactionService transactionService;

    Logger logger = LoggerFactory.getLogger(TransactionController.class);

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/addtransaction")
    public Transaction createTransaction(@RequestBody Transaction transaction){
        logger.error("Transaction ajouter avec success");
        return transactionService.add(transaction);
    }

    @PostMapping(path = "/uptransaction" )
    public Transaction updateTransaction(@RequestBody Transaction transaction){
        return transactionService.update(transaction);
    }

    @DeleteMapping(path = "/deltransaction/{id}")
    public Transaction deleteTransaction(@PathVariable Long id){
        return transactionService.delete(id);
    }

    @GetMapping(path = "/gettransaction/{id}")
    public Transaction getTransaction(@PathVariable Long id){
        return transactionService.getOne(id);
    }

    @GetMapping(path = "/gettransactions")
    public List<Transaction> getTransaction(){
        return transactionService.getAll();
    }
}
