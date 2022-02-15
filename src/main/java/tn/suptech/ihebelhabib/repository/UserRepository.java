package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   @Query("select s from User s where s.username like :x")
   public User findByUsername(@Param("x")String username);
}
