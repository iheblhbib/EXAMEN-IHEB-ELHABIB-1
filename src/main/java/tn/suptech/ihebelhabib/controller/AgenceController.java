package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Agence;
import tn.suptech.ihebelhabib.service.AgenceService;

import java.util.List;

@RestController
@RequestMapping(path = "/agence")
public class AgenceController {

    private AgenceService agenceService;

    Logger logger = LoggerFactory.getLogger(AgenceController.class);

    public AgenceController(AgenceService agenceService){
        this.agenceService = agenceService;
    }

    @PostMapping(path = "/addagence")
    public Agence createAgence(@RequestBody Agence agence){
        logger.error("Agence ajouter avec success");
        return agenceService.add(agence);
    }

    @PostMapping(path = "/upagence" )
    public Agence updateAgence(@RequestBody Agence agence){
        return agenceService.update(agence);
    }

    @DeleteMapping(path = "/delagence/{id}")
    public Agence deleteAgence(@PathVariable Long id){
        return agenceService.delete(id);
    }

    @GetMapping(path = "/getagence/{id}")
    public Agence getAgence(@PathVariable Long id){
        return agenceService.getOne(id);
    }

    @GetMapping(path = "/getagences")
    public List<Agence> getAgences(){
        return agenceService.getAll();
    }
}
