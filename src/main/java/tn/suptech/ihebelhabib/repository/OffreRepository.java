package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.domain.Offre;

@Repository
public interface OffreRepository extends JpaRepository<Offre,Long> {
}
