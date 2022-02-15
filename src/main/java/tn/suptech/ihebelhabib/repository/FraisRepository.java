package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.domain.Frais;

@Repository
public interface FraisRepository extends JpaRepository<Frais,Long> {
}
