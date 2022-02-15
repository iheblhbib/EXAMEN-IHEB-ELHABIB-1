package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.domain.Carte;
import tn.suptech.ihebelhabib.service.CarteService;

import java.util.List;

@RestController
@RequestMapping(path = "/carte")
public class CarteController {

    @Autowired
    private CarteService carteService;

    Logger logger = LoggerFactory.getLogger(CarteController.class);

    @PostMapping(path = "/add")
    public Carte createCarte(@RequestBody Carte carte){
        logger.info("ajout une carte");
        return carteService.add(carte);
    }

    @PostMapping(path = "/update" )
    public Carte updateCarte(@RequestBody Carte carte){
        logger.info("mis à jour une carte");
        return carteService.update(carte);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Carte deleteCarte(@PathVariable Long id){
        logger.info("supprim une carte");
        return carteService.delete(id);
    }

    @GetMapping(path = "/carte/{id}")
    public Carte getCarte(@PathVariable Long id){
        logger.info("obtenir une carte");
        return carteService.getOne(id);
    }

    @GetMapping(path = "/")
    public List<Carte> getCartes(){
        logger.info("obtenir les cartes");
        return carteService.getAll();
    }
}
