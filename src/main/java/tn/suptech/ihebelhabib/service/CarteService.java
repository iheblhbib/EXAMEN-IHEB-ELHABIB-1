package tn.suptech.ihebelhabib.service;

import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Carte;
import tn.suptech.ihebelhabib.repository.CarteRepository;

import java.util.List;

@Service
public class CarteService {

    private CarteRepository carteRepository;

    public CarteService(CarteRepository carteRepository){
        this.carteRepository = carteRepository;
    }

    public List<Carte> getAll(){
        return carteRepository.findAll();
    }

    public Carte getOne(Long id){
        return carteRepository.findById(id).get();
    }

    public Carte add(Carte carte){
        return carteRepository.save(carte);
    }

    public Carte update(Carte carte){
        return carteRepository.save(carte);
    }

    public Carte delete(Long id){
        Carte deletedCarte = this.getOne(id);
        carteRepository.delete(deletedCarte);
        return deletedCarte;
    }
}
