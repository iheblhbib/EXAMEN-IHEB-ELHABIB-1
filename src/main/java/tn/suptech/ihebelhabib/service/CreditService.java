package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.domain.Credit;
import tn.suptech.ihebelhabib.enums.EtatCredit;
import tn.suptech.ihebelhabib.repository.CreditRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    public List<Credit> getAll(){
        return creditRepository.findAll();
    }

    public Credit getOne(Long id){
        return creditRepository.findById(id).get();
    }

    public Credit add(Credit credit){
        credit.setAgios(0);
        credit.setEtat(EtatCredit.NONPAYEE);
        return creditRepository.save(credit);
    }

    public Credit update(Credit credit){
        return creditRepository.save(credit);
    }

    public Credit changeEtat(Credit credit){

        // recupéré les deux dates
        Date depot = credit.getDepot();

        Date interrogation = credit.getInterrogation();

        //convertir les dates en localdate pour calculer le nombre de jours
        LocalDate dateDepot = depot.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate dateInterrogation = interrogation.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Period period = Period.between(dateDepot, dateInterrogation);

        int diff = period.getDays();

        credit.setAgios((credit.getMontant() * credit.getCompte().getTaux() * Math.abs(diff) /100 ) / 365);

        credit.setEtat(EtatCredit.PAYEE);

        return creditRepository.save(credit);

    }


}
