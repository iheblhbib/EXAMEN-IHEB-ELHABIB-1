package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Carte;
import tn.suptech.ihebelhabib.service.CarteService;

import java.util.List;

@RestController
@RequestMapping(path = "/carte")
public class CarteController {

    private CarteService carteService;

    Logger logger = LoggerFactory.getLogger(CarteController.class);

    public CarteController(CarteService carteService){
        this.carteService = carteService;
    }

    @PostMapping(path = "/addcarte")
    public Carte createCarte(@RequestBody Carte carte){
        logger.error("Carte ajouter avec success");
        return carteService.add(carte);
    }

    @PostMapping(path = "/upcarte" )
    public Carte updateCarte(@RequestBody Carte carte){
        return carteService.update(carte);
    }

    @DeleteMapping(path = "/delcarte/{id}")
    public Carte deleteCarte(@PathVariable Long id){
        return carteService.delete(id);
    }

    @GetMapping(path = "/getcarte/{id}")
    public Carte getCarte(@PathVariable Long id){
        return carteService.getOne(id);
    }

    @GetMapping(path = "/getcartes")
    public List<Carte> getCartes(){
        return carteService.getAll();
    }
}
