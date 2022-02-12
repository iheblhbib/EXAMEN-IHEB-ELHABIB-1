package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Adresse;
import tn.suptech.ihebelhabib.repository.AdresseRepository;

import java.util.List;

@Service
public class AdresseService {

    @Autowired
    private AdresseRepository adresseRepository;

    public List<Adresse> getAll(){
        return adresseRepository.findAll();
    }

    public Adresse getOne(Long id){
        return adresseRepository.findById(id).get();
    }

    public Adresse add(Adresse adresse){
        return adresseRepository.save(adresse);
    }

    public Adresse update(Adresse adresse){
        return adresseRepository.save(adresse);
    }

    public Adresse delete(Long id){
        Adresse deletedAdresse = this.getOne(id);
        try {
            adresseRepository.delete(deletedAdresse);
            return deletedAdresse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
