package ph.com.alliance.ServiceChargeApp5.User.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ph.com.alliance.ServiceChargeApp5.User.entity.User;
import ph.com.alliance.ServiceChargeApp5.User.messages.UserMessages;
import ph.com.alliance.ServiceChargeApp5.User.service.UserService;
import ph.com.alliance.ServiceChargeApp5.common.models.ApiResponse;


@RestController
public class UserController {

	private UserService userService;
	
	

	@Autowired
	public UserController(final UserService userService)  {
		this.userService = userService;
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
    public ApiResponse loginUser(@RequestBody User user) {
        User loggedUser = userService.loginUser(user.getEmail(), user.getPassword());
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
	public ApiResponse updateUser(final @PathVariable int id, @RequestBody final User user) {
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
	
}
