package ph.com.alliance.ServiceChargeApp5.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ph.com.alliance.ServiceChargeApp5.User.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    User findByUsernameAndPassword(@Param("email") String email, @Param("password") String password);

	

}
