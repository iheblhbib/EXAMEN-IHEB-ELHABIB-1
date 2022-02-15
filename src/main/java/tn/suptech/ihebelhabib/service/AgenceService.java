package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.domain.Agence;
import tn.suptech.ihebelhabib.repository.AgenceRepository;

import java.util.List;

@Service
public class AgenceService {

    @Autowired
    private AgenceRepository agenceRepository;

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
        try {
            agenceRepository.delete(deletedAgence);
            return deletedAgence;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
