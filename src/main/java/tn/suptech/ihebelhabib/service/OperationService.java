package tn.suptech.ihebelhabib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Operation;
import tn.suptech.ihebelhabib.repository.OperationRepository;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    public List<Operation> getAll(){
        return operationRepository.findAll();
    }

    public Operation getOne(Long id){
        return operationRepository.findById(id).get();
    }

    public Operation add(Operation operation){
        return operationRepository.save(operation);
    }

}
