package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.domain.Client;
import tn.suptech.ihebelhabib.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Client getOne(Long id){
        return clientRepository.findById(id).get();
    }

    public Client add(Client client){
        return clientRepository.save(client);
    }

    public Client update(Client client){
        return clientRepository.save(client);
    }

    public Client delete(Long id){
        Client deletedClient = this.getOne(id);
        try {
            clientRepository.delete(deletedClient);
            return deletedClient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
