package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.domain.Frais;
import tn.suptech.ihebelhabib.repository.FraisRepository;

import java.util.List;

@Service
public class FraisService {

    @Autowired
    private FraisRepository fraisRepository;

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

        try {

            fraisRepository.delete(deletedFrais);

            return deletedFrais;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }
}
