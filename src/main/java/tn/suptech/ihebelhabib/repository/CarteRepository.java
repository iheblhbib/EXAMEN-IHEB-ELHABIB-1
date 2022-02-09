package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.entities.Carte;

@Repository
public interface CarteRepository extends JpaRepository<Carte,Long> {
}
