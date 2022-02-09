package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.entities.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
