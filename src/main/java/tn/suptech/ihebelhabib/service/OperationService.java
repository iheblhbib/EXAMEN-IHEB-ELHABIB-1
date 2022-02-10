package tn.suptech.ihebelhabib.service;

import org.springframework.stereotype.Service;
import tn.suptech.ihebelhabib.entities.Operation;
import tn.suptech.ihebelhabib.repository.OperationRepository;

import java.util.List;

@Service
public class OperationService {

    private OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository){
        this.operationRepository = operationRepository;
    }

    public List<Operation> getAll(){
        return operationRepository.findAll();
    }

    public Operation getOne(Long id){
        return operationRepository.findById(id).get();
    }

    public Operation add(Operation operation){
        return operationRepository.save(operation);
    }

    public Operation update(Operation operation){
        return operationRepository.save(operation);
    }

    public Operation delete(Long id){
        Operation deletedOperation = this.getOne(id);
        operationRepository.delete(deletedOperation);
        return deletedOperation;
    }
}
