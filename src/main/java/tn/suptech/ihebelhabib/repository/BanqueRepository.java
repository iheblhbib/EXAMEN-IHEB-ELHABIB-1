package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.domain.Banque;

@Repository
public interface BanqueRepository extends JpaRepository<Banque,Long> {
}
