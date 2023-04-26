package ph.com.alliance.ServiceChargeApp5.User.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.alliance.ServiceChargeApp5.Role.entity.Role;
import ph.com.alliance.ServiceChargeApp5.Role.repository.RoleRepository;
import ph.com.alliance.ServiceChargeApp5.User.entity.User;
import ph.com.alliance.ServiceChargeApp5.User.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;

	@Autowired
	public UserServiceImpl(final UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}
	
	public User getUserByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		return user.orElse(null);
	}

	public User insertUser(User userDetails) {
		Role role = roleRepository.findById(userDetails.getRole().getRole_id())
				.orElseThrow(() -> new RuntimeException("Role not found"));

		// Map UserDTO to User entity
		User user = new User();
		user.setUsername(userDetails.getUsername());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setStatus(userDetails.getStatus());
		user.setRole(role);

		// Save the User entity to the database
		return userRepository.saveAndFlush(user);

	}

	public List<User> getAllUsers() {
		List<User> userList = userRepository.findAll();
		return userList != null ? userList : Collections.emptyList();
	}

	public User loginUser(String username, String password) {
		return userRepository.findByEmailAndPassword(username, password);
	}

	public User updateUser(int id, User user) {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			user.setUser_id(id); // set the user id to the specified id
			User result = userRepository.saveAndFlush(user);
			return result;
		} else {
			return null;

		}
	}

	public User deleteUser(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.deleteById(id);
			return user.get();
		} else {
			return null;
		}
	}
	
	public String updatePassword(String email, String newPassword) {
		Optional<User> existingUser = userRepository.findByEmail(email);
		if (existingUser.isPresent()) {
			User user = existingUser.get();

			user.setPassword(newPassword);; // set the user id to the specified id
			userRepository.saveAndFlush(user);
			return "Change Password Success";
		} else {
			return null;

		}
	}

	

}
