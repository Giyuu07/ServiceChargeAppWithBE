package ph.com.alliance.ServiceChargeApp5.User.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
    private String password;
}
