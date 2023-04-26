package ph.com.alliance.ServiceChargeApp5.Attachment.messages;

public interface AttachmentMessages {
	// ADD
	String ATTACHMENT_UNSUCCESSFUL_ADD = "Attachment creation failed!";
	String ATTACHMENT_SUCCESSFUL_ADD = "Attachment was successfully added!";
	// DELETE

	String ATTACHMENT_NOT_DELETED = "Attachment deletion failed";
	String ATTACHMENT_DELETED = "Attachment has been deleted!";
	// SINGLE GET
	String ATTACHMENT_UNSUCCESSFUL_GET = "Attachment was not retrieved!";
	String ATTACHMENT_SUCCESSFUL_GET = "Attachment was successfully retrieved!";
	// SAVE
	String ATTACHMENT_UNSUCCESSFUL_SAVE = "Attachment was not saved!";
	String ATTACHMENT_SUCCESSFUL_SAVE = "Attachment was successfully saved!";
	// GET ALL
	String ATTACHMENT_UNSUCCESSFUL_GETALL = "Attachment was not successfully retrieved!";
	String ATTACHMENT_SUCCESSFUL_GETALL = "Attachment was successfully retrieved!";
	// UPDATE
	String ATTACHMENT_UNSUCCESSFUL_UPDATE = "Attachment was not successfully updated!";
	String ATTACHMENT_SUCCESSFUL_UPDATE = "Attachment was successfully updated!";
}

