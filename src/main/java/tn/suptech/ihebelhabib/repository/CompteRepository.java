package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Long> {
    @Query("select s from COMPTE s where s.rib = :x")
    public Compte chercher(@Param("x")int rib);
}
