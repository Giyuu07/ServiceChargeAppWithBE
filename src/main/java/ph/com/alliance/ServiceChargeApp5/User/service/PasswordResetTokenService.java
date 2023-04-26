package ph.com.alliance.ServiceChargeApp5.User.service;


import org.springframework.stereotype.Service;

import ph.com.alliance.ServiceChargeApp5.User.entity.PasswordResetToken;

@Service
public interface PasswordResetTokenService {
	PasswordResetToken createPasswordResetToken(String email);
	PasswordResetToken checkTokenExist(String token);
}
