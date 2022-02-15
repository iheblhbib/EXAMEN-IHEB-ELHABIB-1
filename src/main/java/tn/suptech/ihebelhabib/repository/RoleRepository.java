package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
