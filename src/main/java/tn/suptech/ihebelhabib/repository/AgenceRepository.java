package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.entities.Agence;

@Repository
public interface AgenceRepository extends JpaRepository<Agence,Long> {
}
