package tn.suptech.ihebelhabib.service;

import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Agence;
import tn.suptech.ihebelhabib.repository.AgenceRepository;

import java.util.List;

@Service
public class AgenceService {

    private AgenceRepository agenceRepository;

    public AgenceService(AgenceRepository agenceRepository){
        this.agenceRepository = agenceRepository;
    }

    public List<Agence> getAll(){
        return agenceRepository.findAll();
    }

    public Agence getOne(Long id){
        return agenceRepository.findById(id).get();
    }

    public Agence add(Agence agence){
        return agenceRepository.save(agence);
    }

    public Agence update(Agence agence){
        return agenceRepository.save(agence);
    }

    public Agence delete(Long id){
        Agence deletedAgence = this.getOne(id);
        agenceRepository.delete(deletedAgence);
        return deletedAgence;
    }



}
