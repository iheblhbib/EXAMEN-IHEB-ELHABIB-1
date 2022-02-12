package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Frais;
import tn.suptech.ihebelhabib.service.FraisService;

import java.util.List;

@RestController
@RequestMapping(path = "/frais")
public class FraisController {

    @Autowired
    private FraisService fraisService;

    Logger logger = LoggerFactory.getLogger(FraisController.class);

    @PostMapping(path = "/add")
    public Frais createFrais(@RequestBody Frais frais){
        logger.info("ajout un frais");
        return fraisService.add(frais);
    }

    @PostMapping(path = "/update" )
    public Frais updateFrais(@RequestBody Frais frais){
        logger.info("mis à jour un frais");
        return fraisService.update(frais);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Frais deleteFrais(@PathVariable Long id){
        logger.info("supprime un frais");
        return fraisService.delete(id);
    }

    @GetMapping(path = "/frais/{id}")
    public Frais getFrais(@PathVariable Long id){
        logger.info("obtenir un frais");
        return fraisService.getOne(id);
    }

    @GetMapping(path = "/")
    public List<Frais> getFrais(){
        logger.info("obtenir les frais");
        return fraisService.getAll();
    }
}