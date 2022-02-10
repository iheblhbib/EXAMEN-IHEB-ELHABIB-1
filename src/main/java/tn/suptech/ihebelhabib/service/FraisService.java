package tn.suptech.ihebelhabib.service;

import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Frais;
import tn.suptech.ihebelhabib.repository.FraisRepository;

import java.util.List;

@Service
public class FraisService {

    private FraisRepository fraisRepository;

    public FraisService(FraisRepository fraisRepository){
        this.fraisRepository = fraisRepository;
    }

    public List<Frais> getAll(){
        return fraisRepository.findAll();
    }

    public Frais getOne(Long id){
        return fraisRepository.findById(id).get();
    }

    public Frais add(Frais frais){
        return fraisRepository.save(frais);
    }

    public Frais update(Frais frais){
        return fraisRepository.save(frais);
    }

    public Frais delete(Long id){
        Frais deletedFrais = this.getOne(id);
        fraisRepository.delete(deletedFrais);
        return deletedFrais;
    }
}
