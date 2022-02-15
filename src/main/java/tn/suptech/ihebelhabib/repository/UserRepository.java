package tn.suptech.ihebelhabib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.ihebelhabib.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
   public User findByUserame(String UserName);
}
