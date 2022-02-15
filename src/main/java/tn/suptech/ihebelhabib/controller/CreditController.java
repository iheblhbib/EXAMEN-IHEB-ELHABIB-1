package tn.suptech.ihebelhabib.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.domain.Credit;
import tn.suptech.ihebelhabib.service.CreditService;

import java.util.List;

@RestController
@RequestMapping(path="/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;

    Logger logger = LoggerFactory.getLogger(CreditController.class);

    @PostMapping(path = "/add")
    public Credit createCredit(@RequestBody Credit credit){
        logger.info("ajout un Credit");
        return creditService.add(credit);
    }

    @PostMapping(path = "/update" )
    public Credit updateCredit(@RequestBody Credit credit){
        logger.info("mis à jour un Credit");
        return creditService.update(credit);
    }

    @PostMapping(path = "/payeeCredit" )
    public Credit changeEtat(@RequestBody Credit credit){
        logger.info("mis à jour un Credit");
        return creditService.changeEtat(credit);
    }


    @GetMapping(path = "/credit/{id}")
    public Credit getCredit(@PathVariable Long id){
        logger.info("obtenir un Credit");
        return creditService.getOne(id);
    }

    @GetMapping(path = "/")
    public List<Credit> getCredit(){
        logger.info("obtenir les Credit");
        return creditService.getAll();
    }
}
