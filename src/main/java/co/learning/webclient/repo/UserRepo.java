package co.learning.webclient.repo;

import co.learning.webclient.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "usersRepo")
public interface UserRepo extends JpaRepository<User,String> {

}
