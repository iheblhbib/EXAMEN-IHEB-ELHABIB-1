package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Client;
import tn.suptech.ihebelhabib.service.ClientService;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    private ClientService clientService;

    Logger logger = LoggerFactory.getLogger(ClientController.class);

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping(path = "/addcliet")
    public Client createClient(@RequestBody Client client){
        logger.error("Client ajouter avec success");
        return clientService.add(client);
    }

    @PostMapping(path = "/upclient" )
    public Client updateClient(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping(path = "/delclient/{id}")
    public Client deleteClient(@PathVariable Long id){
        return clientService.delete(id);
    }

    @GetMapping(path = "/getclient/{id}")
    public Client getClient(@PathVariable Long id){
        return clientService.getOne(id);
    }

    @GetMapping(path = "/getclients")
    public List<Client> getClients(){
        return clientService.getAll();
    }
}
