package ph.com.alliance.ServiceChargeApp5.User.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.ServiceChargeApp5.User.entity.ChangePasswordRequest;
import ph.com.alliance.ServiceChargeApp5.User.entity.LoginRequest;
import ph.com.alliance.ServiceChargeApp5.User.entity.PasswordResetToken;
import ph.com.alliance.ServiceChargeApp5.User.entity.User;
import ph.com.alliance.ServiceChargeApp5.User.messages.UserMessages;
import ph.com.alliance.ServiceChargeApp5.User.service.PasswordResetTokenService;
import ph.com.alliance.ServiceChargeApp5.User.service.UserService;
import ph.com.alliance.ServiceChargeApp5.common.component.EmailServiceComponent;
import ph.com.alliance.ServiceChargeApp5.common.models.ApiResponse;


@RestController
public class UserController {

	private UserService userService;
	private PasswordResetTokenService passwordResetTokenService;
	private EmailServiceComponent mailComponent;
	
	@Autowired
	public UserController(UserService userService, PasswordResetTokenService passwordResetTokenService,
			EmailServiceComponent mailComponent) {
		this.userService = userService;
		this.passwordResetTokenService = passwordResetTokenService;
		this.mailComponent = mailComponent;
	}


	@GetMapping("/user/{id}")
	public ApiResponse getUser(final @PathVariable int id)
	{
		final User result = userService.getUserById(id);
		if (null == result) {
			return ApiResponse.CreateError(null, UserMessages.USER_UNSUCCESSFUL_GET);
		} else {
			return ApiResponse.CreateSuccess(result, UserMessages.USER_SUCCESSFUL_GET);
		}
	}
	@PostMapping("/login")
    public ApiResponse loginUser(@RequestBody LoginRequest loginRequest) {
        User loggedUser = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
    	if (null == loggedUser) {
			return ApiResponse.CreateError(null,UserMessages.USER_UNSUCCESSFUL_LOGIN);
		} else {
			return ApiResponse.CreateSuccess(loggedUser, UserMessages.USER_SUCCESSFUL_LOGIN);
		}
    }

	@GetMapping("/users")
	public ApiResponse getAllUsers() {
		final List<User> result = userService.getAllUsers();
		if (null == result) {
			return ApiResponse.CreateError(null,UserMessages.USER_UNSUCCESSFUL_GETALL);
		} else {
			return ApiResponse.CreateSuccess(result, UserMessages.USER_SUCCESSFUL_GETALL);
		}
	}

	@PostMapping("/user/create")
	public ApiResponse createUser(@Valid @RequestBody User userDetails) {
	    User result = userService.insertUser(userDetails);
	    if (null == result) {
	        return ApiResponse.CreateError(null,UserMessages.USER_UNSUCCESSFUL_SAVE);
	    } else {
	        return ApiResponse.CreateSuccess(result, UserMessages.USER_SUCCESSFUL_SAVE);
	    }
	}

	
	@PutMapping("/user/update/{id}")
	public ApiResponse updateUser(final @PathVariable int id, final  @RequestBody User
			user) {
		User result = userService.updateUser(id,user);
		if (null == result) {
			return ApiResponse.CreateError(null,UserMessages.USER_SUCCESSFUL_UPDATE);
		} else {
			return ApiResponse.CreateSuccess(result, UserMessages.USER_UNSUCCESSFUL_UPDATE);
		}
	}
	
	@DeleteMapping("/user/delete/{id}")
	public ApiResponse deleteTicket(final @PathVariable int id) {
		User result = userService.deleteUser(id);
		if (null == result) {
			return ApiResponse.CreateError(null, UserMessages.USER_NOT_DELETED);
		} else {
			return ApiResponse.CreateSuccess(result, UserMessages.USER_DELETED);
		}
	}
	
	@GetMapping("/user/email/{email}")
	public ApiResponse getUserByEmail(final @PathVariable String email) {
		User result = userService.getUserByEmail(email);

		if (null == result) {
			return ApiResponse.CreateError(null, UserMessages.USER_UNSUCCESSFUL_GET);
		} else {
			return ApiResponse.CreateSuccess(result, UserMessages.USER_SUCCESSFUL_GET);
		}
	}
	
	@PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam("email")  String email) {
		User result = userService.getUserByEmail(email);

        if (null == result) {
            return ResponseEntity.badRequest().body("User not found");
        }
        
        PasswordResetToken tokenDto = passwordResetTokenService.createPasswordResetToken(result.getEmail());

        mailComponent.sendResetPasswordMessage(result.getEmail(),tokenDto.getToken());


        return ResponseEntity.ok("Password reset link sent to email");
    }
	
	@GetMapping("/forgot-password/token")
	public ApiResponse checkTokenValidExist(final @RequestParam String token) {
		PasswordResetToken result = passwordResetTokenService.checkTokenExist(token);

		if (null == result) {
			return ApiResponse.CreateError(null, "Token does not exist");
		} else {
			return ApiResponse.CreateSuccess(result, "Token exists and valid");
		}
	}
	
	@PostMapping("/update-password")
	public ResponseEntity<String> updatePassword(@RequestBody ChangePasswordRequest request) {
		String result = userService.updatePassword(request.getEmail(), request.getNewPassword());
		if(null == result) {
			return ResponseEntity.badRequest().body("Change password Fail");
		}else {
			return ResponseEntity.ok("Password updated Successfully");
		}
	}
	
	   @DeleteMapping("/tokens/delete/{email}")
	    public ResponseEntity<?> deleteTokensByEmail(@PathVariable String email) {
	        passwordResetTokenService.deleteTokensByEmail(email);
	        return ResponseEntity.ok().build();
	    }
	
}
