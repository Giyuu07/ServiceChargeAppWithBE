package ph.com.alliance.ServiceChargeApp5.User.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.alliance.ServiceChargeApp5.User.entity.PasswordResetToken;
import ph.com.alliance.ServiceChargeApp5.User.repository.PasswordResetTokenRepository;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService{

	 private PasswordResetTokenRepository passwordResetTokenRepository;
	 
	 @Autowired
	 public PasswordResetTokenServiceImpl(PasswordResetTokenRepository passwordResetTokenRepository) {
	
		this.passwordResetTokenRepository = passwordResetTokenRepository;
	}

	public PasswordResetToken createPasswordResetToken(String email) {
		  // Generate a unique token
        String token = UUID.randomUUID().toString();
        
        // Set the expiration time to 1 hour from now
        LocalDateTime expirationTime = LocalDateTime.now().plusHours(1);
        
        // Create a new password reset token and save it to the database
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(token);
        passwordResetToken.setEmail(email);
        passwordResetToken.setExpiryDate(expirationTime);
        return passwordResetTokenRepository.saveAndFlush(passwordResetToken);
	}

	public PasswordResetToken checkTokenExist(String token) {
		Optional<PasswordResetToken> tokenDto = passwordResetTokenRepository.findByToken(token);
		return tokenDto.orElse(null);
	}

}
