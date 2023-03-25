package ph.com.alliance.ServiceChargeApp5.User.messages;

import ph.com.alliance.ServiceChargeApp5.common.Messages;

public interface UserMessages extends Messages{
	String USER_DELETED = "User has been deleted!";
	String USER_NOT_DELETED = "User deletion failed";
	String USER_UNSUCCESSFUL_LOGIN = "User has failed to login!";
	String USER_SUCCESSFUL_LOGIN = "User has successfully login!";
	String USER_UNSUCCESSFUL_GET = "User was not retrieved!";
	String USER_SUCCESSFUL_GET = "User was successfully retrieved!";
	String USER_UNSUCCESSFUL_SAVE = "User was not saved!";
	String USER_SUCCESSFUL_SAVE = "User was successfully saved!";
}
