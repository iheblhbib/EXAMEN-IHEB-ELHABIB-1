package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Compte;
import tn.suptech.ihebelhabib.repository.CompteRepository;

import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> getAll(){
        return compteRepository.findAll();
    }

    public Compte getOne(Long id){
        return compteRepository.findById(id).get();
    }

    public Compte add(Compte compte){
        return compteRepository.save(compte);
    }

    public Compte update(Compte compte){
        return compteRepository.save(compte);
    }

    public Compte rechercher(int rib){
        return compteRepository.chercher(rib);
    }

    public Compte delete(Long id){
        Compte deletedCompte = this.getOne(id);
        try {
            compteRepository.delete(deletedCompte);
            return deletedCompte;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
