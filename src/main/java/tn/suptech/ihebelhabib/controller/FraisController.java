package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Frais;
import tn.suptech.ihebelhabib.service.FraisService;

import java.util.List;

@RestController
@RequestMapping(path = "/frais")
public class FraisController {

    private FraisService fraisService;

    Logger logger = LoggerFactory.getLogger(FraisController.class);

    public FraisController(FraisService fraisService){
        this.fraisService = fraisService;
    }

    @PostMapping(path = "/addfrais")
    public Frais createFrais(@RequestBody Frais frais){
        logger.error("Frais ajouter avec success");
        return fraisService.add(frais);
    }

    @PostMapping(path = "/upfrais" )
    public Frais updateFrais(@RequestBody Frais frais){
        return fraisService.update(frais);
    }

    @DeleteMapping(path = "/delfrais/{id}")
    public Frais deleteFrais(@PathVariable Long id){
        return fraisService.delete(id);
    }

    @GetMapping(path = "/getfrais/{id}")
    public Frais getFrais(@PathVariable Long id){
        return fraisService.getOne(id);
    }

    @GetMapping(path = "/getfrais")
    public List<Frais> getFrais(){
        return fraisService.getAll();
    }
}