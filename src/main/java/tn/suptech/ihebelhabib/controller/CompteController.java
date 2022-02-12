package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Compte;
import tn.suptech.ihebelhabib.service.CompteService;

import java.util.List;

@RestController
@RequestMapping(path = "/compte")
public class CompteController {

    private CompteService compteService;

    Logger logger = LoggerFactory.getLogger(CompteController.class);

    public CompteController(CompteService compteService){
        this.compteService = compteService;
    }

    @PostMapping(path = "/addcompte")
    public Compte createCompte(@RequestBody Compte compte){
        logger.error("Compte ajouter avec success");
        return compteService.add(compte);
    }

    @PostMapping(path = "/upcompte" )
    public Compte updateCompte(@RequestBody Compte compte){
        return compteService.update(compte);
    }

    @DeleteMapping(path = "/delcompte/{id}")
    public Compte deleteCompte(@PathVariable Long id){
        return compteService.delete(id);
    }

    @GetMapping(path = "/getcompte/{id}")
    public Compte getCompte(@PathVariable Long id){
        return compteService.getOne(id);
    }

    @GetMapping(path = "/getcomptes")
    public List<Compte> getComptes(){
        return compteService.getAll();
    }
}