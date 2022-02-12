package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.entities.Operation;
import tn.suptech.ihebelhabib.service.OperationService;

import java.util.List;

@RestController
@RequestMapping(path = "/operation")
public class OperationController {

    private OperationService operationService;

    Logger logger = LoggerFactory.getLogger(OperationController.class);

    public OperationController(OperationService operationService){
        this.operationService = operationService;
    }

    @PostMapping(path = "/addoperation")
    public Operation createOperation(@RequestBody Operation operation){
        logger.error("Operation ajouter avec success");
        return operationService.add(operation);
    }

    @PostMapping(path = "/upoperation" )
    public Operation updateOperation(@RequestBody Operation operation){
        return operationService.update(operation);
    }

    @DeleteMapping(path = "/deloperation/{id}")
    public Operation deleteOperation(@PathVariable Long id){
        return operationService.delete(id);
    }

    @GetMapping(path = "/getoperation/{id}")
    public Operation getOperation(@PathVariable Long id){
        return operationService.getOne(id);
    }

    @GetMapping(path = "/getoperations")
    public List<Operation> getOperation(){
        return operationService.getAll();
    }
}
