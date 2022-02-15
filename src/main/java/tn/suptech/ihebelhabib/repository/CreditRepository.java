package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.domain.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit,Long> {
}
