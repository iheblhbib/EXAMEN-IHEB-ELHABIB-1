package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.entities.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse,Long> {
}
