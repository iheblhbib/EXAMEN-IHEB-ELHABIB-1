package tn.suptech.ihebelhabib.service;

import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Offre;
import tn.suptech.ihebelhabib.repository.OffreRepository;

import java.util.List;

@Service
public class OffreService {

    private OffreRepository offreRepository;

    public OffreService(OffreRepository offreRepository){
        this.offreRepository = offreRepository;
    }

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
        offreRepository.delete(deletedOffre);
        return deletedOffre;
    }
}
