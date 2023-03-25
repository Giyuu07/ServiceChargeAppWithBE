package ph.com.alliance.ServiceChargeApp5.User.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotSupportedException;

import com.google.gson.Gson;

import ph.com.alliance.ServiceChargeApp5.User.entity.User;
import ph.com.alliance.ServiceChargeApp5.User.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	/**
	 * Repository
	 */
	private UserRepository userRepository;
	
	/**
	 * Used to convert object to JSON or vice-versa
	 */
	private Gson gson;
	
	/**
	 * Autowired Constructor of the User Service class
	 * @param userRepository - User Repository to be injected
	 */
	@Autowired
	public UserServiceImpl(final UserRepository userRepository)
	{
		this.userRepository = userRepository;
		gson = new Gson();
	}

	/**
	 * Gets the user via ID and checks if retrieval is a success or not
	 * @param id used to determine which account to retrieve in the repository
	 * @return String which contains the message if retrieval is a success or not
	 */
	public String getUserID(final int id) {
		final Optional<User> user = userRepository.findById(id);
		
		if (user.isPresent()) {
			return gson.toJson(user.get());
		} else {
			return null;
		}
	}
	
	/**
	 * Inserts the user into the database
	 * @param user to be inserted
	 * @return String which contains the message if insertion is a success or not
	 */
	public String insertUser(final User user)
	{
		final User result = userRepository.saveAndFlush(user);
		return "success";
	}
	
	/**
	 * Gets all the users in the database
	 * @return String which contains the JSON-ified objects
	 */
	public String getAllUsers()
	{
		final List<User> userList = userRepository.findAll();
		return gson.toJson(userList);
	}

	public User loginUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }
//	 public User loginUser(String username, String password) {
//	        User user = userRepository.findByUsernameAndPassword(username, password);
//	        if (user == null) {
//	            throw new RuntimeException("Invalid username or password");
//	        }
//	        return user;
//	    }
//	 public String loginUser(String userEmail, String userPassword) {
//	        User user = userRepository.findByUsernameAndPassword(userEmail, userPassword);
//	        if (user == null) {
//	            throw new RuntimeException("Invalid username or password");
//	        }
//	        return gson.toJson(user);
//	    }
}
