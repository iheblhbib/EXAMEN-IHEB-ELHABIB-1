package tn.suptech.ihebelhabib.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Adresse;
import tn.suptech.ihebelhabib.service.AdresseService;

import java.util.List;

@RestController
@RequestMapping(path = "/adresse")
public class AdresseController {

    private AdresseService adresseService;

    Logger logger = LoggerFactory.getLogger(AdresseController.class);

    public AdresseController(AdresseService adresseService){
        this.adresseService = adresseService;
    }

    @PostMapping(path = "/addadresse")
    public Adresse createAdresse(@RequestBody Adresse adresse){
        return adresseService.add(adresse);
    }

    @PostMapping(path = "/upadresse" )
    public Adresse updateAdresse(@RequestBody Adresse adresse){
        return adresseService.update(adresse);
    }

    @DeleteMapping(path = "/deladresse/{id}")
    public Adresse deleteAdresse(@PathVariable Long id){
        return adresseService.delete(id);
    }

    @GetMapping(path = "/getadresse/{id}")
    public Adresse getAdresse(@PathVariable Long id){
        return adresseService.getOne(id);
    }

    @GetMapping(path = "/getadresses")
    public List<Adresse> getAdresses(){

        logger.debug("test");
        return adresseService.getAll();
    }
}
