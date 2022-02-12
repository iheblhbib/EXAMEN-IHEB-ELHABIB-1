package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Banque;
import tn.suptech.ihebelhabib.service.BanqueService;

import java.util.List;

@RestController
@RequestMapping(path = "/banque")
public class BanqueController {

    @Autowired
    private BanqueService banqueService;

    Logger logger = LoggerFactory.getLogger(BanqueController.class);

    @PostMapping(path = "/add")
    public Banque createBanque(@RequestBody Banque banque){
        logger.info("ajout une banque");
        return banqueService.add(banque);
    }

    @PostMapping(path = "/update" )
    public Banque updateBanque(@RequestBody Banque banque){
        logger.info("mis à jour une banque");
        return banqueService.update(banque);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Banque deleteBanque(@PathVariable Long id){
        logger.info("supprim une banque");
        return banqueService.delete(id);
    }

    @GetMapping(path = "/banque/{id}")
    public Banque getBanque(@PathVariable Long id){
        logger.info("obtenir une banque");
        return banqueService.getOne(id);
    }

    @GetMapping(path = "/")
    public List<Banque> getBanques(){
        logger.info("obtenir les banques");
        return banqueService.getAll();
    }
}
