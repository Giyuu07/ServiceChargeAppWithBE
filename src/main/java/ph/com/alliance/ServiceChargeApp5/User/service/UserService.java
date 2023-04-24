package ph.com.alliance.ServiceChargeApp5.User.service;


import java.util.List;

import org.springframework.stereotype.Service;

import ph.com.alliance.ServiceChargeApp5.User.entity.User;

@Service
public interface UserService {
	User getUserById(final int id);
	User loginUser(String userEmail, String userPassword);
	
//	User Management
//	List	
	List<User> getAllUsers();
//	Add
	User insertUser(final User user);
//	Edit
	User updateUser(final int id, final User user);
//	Delete
	User deleteUser(final int id);
	
	

}
