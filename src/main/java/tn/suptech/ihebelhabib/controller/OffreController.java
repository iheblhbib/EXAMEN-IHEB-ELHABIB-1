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

    @PostMapping(path = "/add")
    public Offre createOffre(@RequestBody Offre offre){
        logger.info("ajout une offre");
        return offreService.add(offre);
    }

    @PostMapping(path = "/update" )
    public Offre updateOffre(@RequestBody Offre offre){
        logger.info("mis à jour une offre");
        return offreService.update(offre);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Offre deleteOffre(@PathVariable Long id){
        logger.info("supprime une offre");
        return offreService.delete(id);
    }

    @GetMapping(path = "/offre/{id}")
    public Offre getOffre(@PathVariable Long id){
        logger.info("obtenir une offre");
        return offreService.getOne(id);
    }

    @GetMapping(path = "/")
    public List<Offre> getOffre(){
        logger.info("obtenir les offres");
        return offreService.getAll();
    }
}