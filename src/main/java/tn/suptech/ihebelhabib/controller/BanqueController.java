package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Banque;
import tn.suptech.ihebelhabib.service.BanqueService;

import java.util.List;

@RestController
@RequestMapping(path = "/banque")
public class BanqueController {

    private BanqueService banqueService;

    Logger logger = LoggerFactory.getLogger(BanqueController.class);

    public BanqueController(BanqueService banqueService){
        this.banqueService = banqueService;
    }

    @PostMapping(path = "/addbanque")
    public Banque createBanque(@RequestBody Banque banque){
        logger.error("Banque ajouter avec success");
        return banqueService.add(banque);
    }

    @PostMapping(path = "/upbanque" )
    public Banque updateBanque(@RequestBody Banque banque){
        return banqueService.update(banque);
    }

    @DeleteMapping(path = "/delbanque/{id}")
    public Banque deleteBanque(@PathVariable Long id){
        return banqueService.delete(id);
    }

    @GetMapping(path = "/getbanque/{id}")
    public Banque getBanque(@PathVariable Long id){
        return banqueService.getOne(id);
    }

    @GetMapping(path = "/getbanques")
    public List<Banque> getBanques(){
        return banqueService.getAll();
    }
}
