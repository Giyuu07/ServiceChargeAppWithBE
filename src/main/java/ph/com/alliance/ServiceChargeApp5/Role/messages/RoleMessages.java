package ph.com.alliance.ServiceChargeApp5.Role.messages;

import ph.com.alliance.ServiceChargeApp5.common.Messages;

public interface RoleMessages extends Messages{
	// ADD
	String ROLE_UNSUCCESSFUL_ADD = "Role creation failed!";
	String ROLE_SUCCESSFUL_ADD = "Role was successfully added!";
	// DELETE
	String ROLE_DELETED = "Role has been deleted!";
	String ROLE_NOT_DELETED = "Role deletion failed";
	// SINGLE GET
	String ROLE_UNSUCCESSFUL_GET = "Role was not retrieved!";
	String ROLE_SUCCESSFUL_GET = "Role was successfully retrieved!";
	// SAVE
	String ROLE_UNSUCCESSFUL_SAVE = "Role was not saved!";
	String ROLE_SUCCESSFUL_SAVE = "Role was successfully saved!";
	// GET ALL
	String ROLE_UNSUCCESSFUL_GETALL = "Role was not successfully retrieved!";
	String ROLE_SUCCESSFUL_GETALL = "Role was successfully retrieved!";
	// UPDATE
	String ROLE_UNSUCCESSFUL_UPDATE = "Role was not successfully updated!";
	String ROLE_SUCCESSFUL_UPDATE = "Role was successfully updated!";
}
