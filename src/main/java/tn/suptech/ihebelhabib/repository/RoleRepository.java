package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("select s from Role s where s.name like :x")
    public Role findRoleByName(@Param("x")String roleName);
}
