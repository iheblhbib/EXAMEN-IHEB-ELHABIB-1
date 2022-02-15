package tn.suptech.ihebelhabib.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.ihebelhabib.domain.Operation;
import tn.suptech.ihebelhabib.enums.EtatCompte;
import tn.suptech.ihebelhabib.enums.TypeCompte;
import tn.suptech.ihebelhabib.service.OperationService;

import java.util.List;

@RestController
@RequestMapping(path = "/operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    Logger logger = LoggerFactory.getLogger(OperationController.class);

    @PostMapping(path = "/add")
    public Operation createOperation(@RequestBody Operation operation){
        logger.info("ajout une operation");

        TypeCompte typeCompte = operation.getCarte().getCompte().getType();
        EtatCompte etatCompte = operation.getCarte().getCompte().getEtat();
        double retrait = operation.getCarte().getCompte().getMontant();

        // si le compte est courant et n'est pas débiteur ---> valider le retrait
        if(typeCompte.equals(TypeCompte.COURANT) && retrait > 0){
                operation.getCarte().getCompte().setMontant(operation.getNewmontant());
            return operationService.add(operation);

        // si non si le compte est eparne et le compte fermee ---> valider le retrait
        }else if(etatCompte.equals(EtatCompte.FERMEE) && typeCompte.equals(TypeCompte.EPARNE)){
            operation.getCarte().getCompte().setMontant(operation.getNewmontant());
            return operationService.add(operation);
        }else{
            return null;
        }
    }

    @GetMapping(path = "/operation/{id}")
    public Operation getOperation(@PathVariable Long id){
        logger.info("obtenir une operation");
        return operationService.getOne(id);
    }

    @GetMapping(path = "/")
    public List<Operation> getOperation(){
        logger.info("obtenir les operations");
        return operationService.getAll();
    }
}
