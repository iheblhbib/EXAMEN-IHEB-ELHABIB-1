package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.domain.Operation;
import tn.suptech.ihebelhabib.repository.OperationRepository;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private CompteService compteService;

    public List<Operation> getAll(){
        return operationRepository.findAll();
    }

    public Operation getOne(Long id){
        return operationRepository.findById(id).get();
    }

    public Operation add(Operation operation){

        operation.setNewmontant( operation.getOldmontant() - operation.getMontant() - operation.getCarte().getCompte().getCout());

        operation.getCarte().getCompte().setMontant(operation.getNewmontant());

        compteService.update(operation.getCarte().getCompte());

        return operationRepository.save(operation);
    }

}
