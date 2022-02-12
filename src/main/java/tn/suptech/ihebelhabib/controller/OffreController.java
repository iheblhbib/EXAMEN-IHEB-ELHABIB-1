package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Offre;
import tn.suptech.ihebelhabib.service.OffreService;

import java.util.List;

@RestController
@RequestMapping(path = "/offre")
public class OffreController {

    private OffreService offreService;

    Logger logger = LoggerFactory.getLogger(OffreController.class);

    public OffreController(OffreService offreService){
        this.offreService = offreService;
    }

    @PostMapping(path = "/addoffre")
    public Offre createOffre(@RequestBody Offre offre){
        logger.error("Offre ajouter avec success");
        return offreService.add(offre);
    }

    @PostMapping(path = "/upoffre" )
    public Offre updateOffre(@RequestBody Offre offre){
        return offreService.update(offre);
    }

    @DeleteMapping(path = "/deloffre/{id}")
    public Offre deleteOffre(@PathVariable Long id){
        return offreService.delete(id);
    }

    @GetMapping(path = "/getoffre/{id}")
    public Offre getOffre(@PathVariable Long id){
        return offreService.getOne(id);
    }

    @GetMapping(path = "/getoffres")
    public List<Offre> getOffre(){
        return offreService.getAll();
    }
}