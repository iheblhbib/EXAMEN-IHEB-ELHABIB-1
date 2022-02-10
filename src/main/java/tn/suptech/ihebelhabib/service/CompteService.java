package tn.suptech.ihebelhabib.service;

import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Compte;
import tn.suptech.ihebelhabib.repository.CompteRepository;

import java.util.List;

@Service
public class CompteService {

    private CompteRepository compteRepository;

    private CompteService(CompteRepository compteRepository){
        this.compteRepository = compteRepository;
    }

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

    public Compte delete(Long id){
        Compte deletedCompte = this.getOne(id);
        compteRepository.delete(deletedCompte);
        return deletedCompte;
    }
}
