package ph.com.alliance.ServiceChargeApp5.User.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ph.com.alliance.ServiceChargeApp5.User.entity.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	@Query("SELECT t FROM PasswordResetToken t WHERE t.email = :email AND t.token = :token")
    Optional<PasswordResetToken> findByEmailAndToken(String email, String token);
	
	@Query("SELECT t FROM PasswordResetToken t WHERE t.token = :token")
    Optional<PasswordResetToken> findByToken(String token);
}
