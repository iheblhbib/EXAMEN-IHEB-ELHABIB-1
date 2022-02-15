package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.domain.Carte;
import tn.suptech.ihebelhabib.repository.CarteRepository;

import java.util.List;

@Service
public class CarteService {

    @Autowired
    private CarteRepository carteRepository;

    public List<Carte> getAll(){
        return carteRepository.findAll();
    }

    public Carte getOne(Long id){
        return carteRepository.findById(id).get();
    }

    public Carte add(Carte carte){
        carte.getCompte().setMontant( carte.getCompte().getMontant() - carte.getCotisation());
        return carteRepository.save(carte);
    }

    public Carte update(Carte carte){
        return carteRepository.save(carte);
    }

    public Carte delete(Long id){
        Carte deletedCarte = this.getOne(id);
        try {
            carteRepository.delete(deletedCarte);
            return deletedCarte;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
