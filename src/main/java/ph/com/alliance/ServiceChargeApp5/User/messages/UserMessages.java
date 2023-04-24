package ph.com.alliance.ServiceChargeApp5.User.messages;

import ph.com.alliance.ServiceChargeApp5.common.Messages;

public interface UserMessages extends Messages{
	//DELETE
	String USER_NOT_DELETED = "User deletion failed";
	String USER_DELETED = "User has been deleted!";
	//LOGIN
	String USER_UNSUCCESSFUL_LOGIN = "User has failed to login!";
	String USER_SUCCESSFUL_LOGIN = "User has successfully login!";
	//SINGLE GET
	String USER_UNSUCCESSFUL_GET = "User was not retrieved!";
	String USER_SUCCESSFUL_GET = "User was successfully retrieved!";
	//SAVE
	String USER_UNSUCCESSFUL_SAVE = "User was not saved!";
	String USER_SUCCESSFUL_SAVE = "User was successfully saved!";
	//GET ALL
	String USER_UNSUCCESSFUL_GETALL = "Users was not successfully retrieved!";
	String USER_SUCCESSFUL_GETALL = "User was successfully retrieved!";
	//UPDATE
	String USER_UNSUCCESSFUL_UPDATE = "Users was not successfully updated!";
	String USER_SUCCESSFUL_UPDATE = "User was successfully updated!";
}
