package tn.suptech.ihebelhabib.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
