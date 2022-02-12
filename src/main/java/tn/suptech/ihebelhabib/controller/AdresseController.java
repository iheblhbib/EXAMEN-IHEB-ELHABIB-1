package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Adresse;
import tn.suptech.ihebelhabib.service.AdresseService;

import java.util.List;

@RestController
@RequestMapping(path = "/adresse")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    Logger logger = LoggerFactory.getLogger(AdresseController.class);

    @PostMapping(path = "/add")
    public Adresse createAdresse(@RequestBody Adresse adresse){
        logger.info("ajout une adresse");
        return adresseService.add(adresse);
    }

    @PostMapping(path = "/update" )
    public Adresse updateAdresse(@RequestBody Adresse adresse){
        logger.info("mis à jour une adresse");
        return adresseService.update(adresse);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Adresse deleteAdresse(@PathVariable Long id){
        logger.info("supprime une adresse");
        return adresseService.delete(id);
    }

    @GetMapping(path = "/adresse/{id}")
    public Adresse getAdresse(@PathVariable Long id){
        logger.info("obtenir une adresse");
        return adresseService.getOne(id);
    }

    @GetMapping(path = "/")
    public List<Adresse> getAdresses(){
        logger.info("obtenir les adresses");
        return adresseService.getAll();
    }
}
