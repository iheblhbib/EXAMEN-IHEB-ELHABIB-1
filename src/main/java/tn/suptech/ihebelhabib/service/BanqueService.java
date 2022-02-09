package tn.suptech.ihebelhabib.service;

import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Banque;
import tn.suptech.ihebelhabib.repository.BanqueRepository;

import java.util.List;

@Service
public class BanqueService {

    private BanqueRepository banqueRepository;

    public BanqueService(BanqueRepository banqueRepository){
        this.banqueRepository = banqueRepository;
    }

    public List<Banque> getAll(){
        return banqueRepository.findAll();
    }

    public Banque getOne(Long id){
        return banqueRepository.findById(id).get();
    }

    public Banque add(Banque banque){
        return banqueRepository.save(banque);
    }

    public Banque update(Banque banque){
        return banqueRepository.save(banque);
    }

    public Banque delete(Long id){
        Banque deletedBanque = this.getOne(id);
        banqueRepository.delete(deletedBanque);
        return deletedBanque;
    }
}
