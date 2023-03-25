package ph.com.alliance.ServiceChargeApp5.User.service;


import ph.com.alliance.ServiceChargeApp5.User.entity.User;

public interface UserService {
	String getUserID(final int id);
	String insertUser(final User user);
	String getAllUsers();
	User loginUser(String userEmail, String userPassword);
//	String loginUser(String userEmail, String userPassword);

}
