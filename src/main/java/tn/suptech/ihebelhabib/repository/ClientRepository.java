package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
