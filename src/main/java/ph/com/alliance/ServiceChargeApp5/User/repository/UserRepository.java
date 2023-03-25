package ph.com.alliance.ServiceChargeApp5.User.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ph.com.alliance.ServiceChargeApp5.User.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
//	@Query("SELECT * FROM users WHERE LOWER(username.name) = LOWER(:name)")
//	User retrieveByName(@Param("name") String name);
	
//	@Query("SELECT u FROM User u WHERE u.userEmail = :userEmail AND u.userPassword = :userPassword")
//	Optional<User> findByUsernameAndPassword(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);
	
	@Query("SELECT u FROM User u WHERE u.userEmail = :userEmail AND u.userPassword = :userPassword")
    User findByUsernameAndPassword(@Param("userEmail") String userEmail, @Param("userPassword") String userPassword);

	

}
