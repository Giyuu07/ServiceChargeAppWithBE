package ph.com.alliance.ServiceChargeApp5.Ticket.Messages;

import ph.com.alliance.ServiceChargeApp5.common.Messages;

public interface TicketMessages extends Messages {
	// ADD
	String TICKET_UNSUCCESSFUL_ADD = "Ticket creation failed!";
	String TICKET_SUCCESSFUL_ADD = "Ticket was successfully added!";
	// DELETE

	String TICKET_NOT_DELETED = "Ticket deletion failed";
	String TICKET_DELETED = "Ticket has been deleted!";
	// SINGLE GET
	String TICKET_UNSUCCESSFUL_GET = "Ticket was not retrieved!";
	String TICKET_SUCCESSFUL_GET = "Ticket was successfully retrieved!";
	// SAVE
	String TICKET_UNSUCCESSFUL_SAVE = "Ticket was not saved!";
	String TICKET_SUCCESSFUL_SAVE = "Ticket was successfully saved!";
	// GET ALL
	String TICKET_UNSUCCESSFUL_GETALL = "Ticket was not successfully retrieved!";
	String TICKET_SUCCESSFUL_GETALL = "Ticket was successfully retrieved!";
	// UPDATE
	String TICKET_UNSUCCESSFUL_UPDATE = "Ticket was not successfully updated!";
	String TICKET_SUCCESSFUL_UPDATE = "Ticket was successfully updated!";
}
