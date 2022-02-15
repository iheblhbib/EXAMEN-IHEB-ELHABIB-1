package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.domain.Offre;
import tn.suptech.ihebelhabib.repository.OffreRepository;

import java.util.List;

@Service
public class OffreService {

    @Autowired
    private OffreRepository offreRepository;

    public List<Offre> getAll(){
        return offreRepository.findAll();
    }

    public Offre getOne(Long id){
        return offreRepository.findById(id).get();
    }

    public Offre add(Offre offre){
        return offreRepository.save(offre);
    }

    public Offre update(Offre offre){
        return offreRepository.save(offre);
    }

    public Offre delete(Long id){

        Offre deletedOffre = this.getOne(id);

        try {
            offreRepository.delete(deletedOffre);

            return deletedOffre;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}
