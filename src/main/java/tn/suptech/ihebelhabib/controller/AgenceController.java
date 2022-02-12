package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Agence;
import tn.suptech.ihebelhabib.service.AgenceService;

import java.util.List;

@RestController
@RequestMapping(path = "/agence")
public class AgenceController {

    @Autowired
    private AgenceService agenceService;

    Logger logger = LoggerFactory.getLogger(AgenceController.class);

    @PostMapping(path = "/add")
    public Agence createAgence(@RequestBody Agence agence){
        logger.info("ajout une agence");
        return agenceService.add(agence);
    }

    @PostMapping(path = "/update" )
    public Agence updateAgence(@RequestBody Agence agence){
        logger.info("mis à jour une agence");
        return agenceService.update(agence);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Agence deleteAgence(@PathVariable Long id){
        logger.info("supprim une agence");
        return agenceService.delete(id);
    }

    @GetMapping(path = "/agence/{id}")
    public Agence getAgence(@PathVariable Long id){
        logger.info("obtenir une agence");
        return agenceService.getOne(id);
    }

    @GetMapping(path = "/")
    public List<Agence> getAgences(){
        logger.info("obtenir les agences");
        return agenceService.getAll();
    }
}
