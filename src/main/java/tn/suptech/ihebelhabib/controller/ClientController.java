package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.domain.Client;
import tn.suptech.ihebelhabib.service.ClientService;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    Logger logger = LoggerFactory.getLogger(ClientController.class);

    @PostMapping(path = "/add")
    public Client createClient(@RequestBody Client client){
        logger.info("ajout un cliet");
        return clientService.add(client);
    }

    @PostMapping(path = "/update" )
    public Client updateClient(@RequestBody Client client){
        logger.info("mis à jour un cliet");
        return clientService.update(client);
    }

    @DeleteMapping(path = "/delete/{id}")
    public Client deleteClient(@PathVariable Long id){
        logger.info("supprim un cliet");
        return clientService.delete(id);
    }

    @GetMapping(path = "/client/{id}")
    public Client getClient(@PathVariable Long id){
        logger.info("obtenir un cliet");
        return clientService.getOne(id);
    }

    @GetMapping(path = "/")
    public List<Client> getClients(){
        logger.info("obtenir les cliets");
        return clientService.getAll();
    }
}
