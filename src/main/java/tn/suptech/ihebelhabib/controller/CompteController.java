package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Compte;
import tn.suptech.ihebelhabib.service.CompteService;

import java.util.List;

@RestController
@RequestMapping(path = "/compte")
public class CompteController {

    @Autowired
    private CompteService compteService;

    Logger logger = LoggerFactory.getLogger(CompteController.class);

    @PostMapping(path = "/add")
    public Compte createCompte(@RequestBody Compte compte){
        logger.info("ajout un compte");
        return compteService.add(compte);
    }

    @PostMapping(path = "/update" )
    public Compte updateCompte(@RequestBody Compte compte){
        logger.info("mis à jour un compte");
        return compteService.update(compte);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Compte deleteCompte(@PathVariable Long id){
        logger.info("supprim un compte");
        return compteService.delete(id);
    }

    @GetMapping(path = "/compte/{id}")
    public Compte getCompte(@PathVariable Long id){
        logger.info("obtenir un compte");
        return compteService.getOne(id);
    }

    @GetMapping(path = "/")
    public List<Compte> getComptes(){
        logger.info("obtenir les comptes");
        return compteService.getAll();
    }

    @GetMapping(path = "/{rib}")
    public Compte getCompteByRib(@PathVariable int rib){
        logger.info("obtenir un comptes par rib");
        return compteService.rechercher(rib);
    }


}