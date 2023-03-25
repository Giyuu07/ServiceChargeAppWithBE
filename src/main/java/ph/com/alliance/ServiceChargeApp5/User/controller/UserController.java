package ph.com.alliance.ServiceChargeApp5.User.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ph.com.alliance.ServiceChargeApp5.User.entity.User;
import ph.com.alliance.ServiceChargeApp5.User.messages.UserMessages;
import ph.com.alliance.ServiceChargeApp5.User.service.UserService;
import ph.com.alliance.ServiceChargeApp5.common.Messages;
import ph.com.alliance.ServiceChargeApp5.common.models.ApiResponse;

@RestController
public class UserController {
	public static final String VIEW_PATH = "/login.html";

	/**
	 * Service for User (Interface inject)
	 */
	private UserService userService;

	/**
	 * Controller constructor
	 * 
	 * @param userService service to be injected
	 */
	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets all users
	 * 
	 * @return a JSON String
	 */
//	@GetMapping("/user")
//	public String getUsers()
//	{
//		return userService.getAllUsers();
//	}
//	
//	/**
//	 * Gets a specific user
//	 * @param id of the user to be retrieved
//	 * @return a JSON String of the User Object
//	 */
//	@GetMapping("/user/{id}")
//	public ApiResponse getUser(final @PathVariable String id)
//	{
//		final User result = userService.getUserID(id);
//		if (null == result) {
//			return ApiResponse.CreateError(null, UserMessages.USER_UNSUCCESSFUL_GET);
//		} else {
//			return ApiResponse.CreateSuccess(result, UserMessages.USER_SUCCESSFUL_GET);
//		}
//	}
//	@PostMapping(value = "/login", consumes = "application/json")
//    public ResponseEntity<User> loginUser(@RequestBody User user) {
//        User loggedUser = userService.loginUser(user.getUserEmail(), user.getUserPassword());
//        if (loggedUser == null) {
//            return ResponseEntity.badRequest().build();
//        } else {
//            return ResponseEntity.ok(loggedUser);
//        }
//    }
	
	 @PostMapping("/login")
	    public ResponseEntity<User> login(@RequestBody User loginUser) {
	       try {
	    	   User user = userService.loginUser(loginUser.getUserEmail(), loginUser.getUserPassword());
		        return ResponseEntity.ok(user);
	       }catch(Error e) {
	    	   return null;
	       }
	    }

//	@GetMapping("/login/{userEmail}/{userPassword}")
//    public String login(@PathVariable String userEmail, @PathVariable String userPassword) {
//       try {
//    	   String user = userService.loginUser(userEmail, userPassword);
//	        return "Hello " + user;
//       }catch(Error e) {
//    	   return "Hi" + e;
//       }
//    }
//	@PostMapping("/login")
//    public String login(@RequestBody User user) {
//       try {
//    	   User u = userService.loginUser(user.getUserEmail(), user.getUserPassword());
//	        return "Login Successful" + u;
//       }catch(Error e) {
//    	   return "Login Failed" + e;
//       }
//    }
	
	@GetMapping("/user/{id}")
	public String getUser(final @PathVariable int id) {
		final String result = userService.getUserID(id);
		if (null == result) {
			return "No User found";
		} else {
			return result;
		}
	}

	@GetMapping("/users")
	public String getAllUsers() {
//		return gson.toJson(userService.getAllUsers());
		final String result = userService.getAllUsers();
		if (null == result) {
			return "No users";
		} else {
			return result;
		}
	}

	/**
	 * Registers a user
	 * 
	 * @param user to be registered
	 * @return a String which is an indication if it is success or a failure
	 */
	@PostMapping("/user/create")
	public String registerUser(@RequestBody final User user) {
		return userService.insertUser(user);
	}
	
//	@GetMapping("/login")
//	public ModelAndView execute()
//	{
//		return new ModelAndView(VIEW_PATH);
//	}
//	@PostMapping("/login")
//	public String loginUser(@RequestBody final User user) {
//		return "hello";
//	}

	// front end requests -> process sa backend -> make response -> send response
}
