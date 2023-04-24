package ph.com.alliance.ServiceChargeApp5.Ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.ServiceChargeApp5.Ticket.Messages.TicketMessages;
import ph.com.alliance.ServiceChargeApp5.Ticket.entity.Ticket;
import ph.com.alliance.ServiceChargeApp5.Ticket.service.TicketService;
import ph.com.alliance.ServiceChargeApp5.common.models.ApiResponse;

@RestController
public class TicketController {

	private TicketService ticketService;
	
	@Autowired
	public TicketController(final TicketService ticketService)
	{
		this.ticketService = ticketService;		
	}

	@GetMapping("/ticket/{id}")
	public ApiResponse getTicket(final @PathVariable int id) {

		Ticket result = ticketService.getTicketById(id);
		if (null == result) {
			return ApiResponse.CreateError(null, TicketMessages.TICKET_UNSUCCESSFUL_GET);
		} else {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_SUCCESSFUL_GET);
		}

	}

	@GetMapping("/tickets")
	public ApiResponse getTickets() {

		List<Ticket> result = ticketService.getAllTickets();
		if (null == result) {
			return ApiResponse.CreateError(null, TicketMessages.TICKET_UNSUCCESSFUL_GETALL);
		} else {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_SUCCESSFUL_GETALL);
		}
	}

	@GetMapping("/tickets/{status}")
	public ApiResponse getTicketsByStatus(final @PathVariable String status) {

		List<Ticket> result = ticketService.getTicketsByStatus(status);
		if (null == result) {
			return ApiResponse.CreateError(null, TicketMessages.TICKET_UNSUCCESSFUL_GETALL);
		} else {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_SUCCESSFUL_GETALL);
		}
	}

	@GetMapping("/tickets/assignee/{id}")
	public ApiResponse getTicketsByAssignee(final @PathVariable int id) {
		List<Ticket> result = ticketService.getTicketsByTicketAssignee(id);
		if (null == result) {
			return ApiResponse.CreateError(null, TicketMessages.TICKET_UNSUCCESSFUL_GETALL);
		} else {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_SUCCESSFUL_GETALL);
		}
	}

	@GetMapping("/tickets/owner/{id}")
	public ApiResponse getTicketsByOwner(final @PathVariable int id) {
		List<Ticket> result = ticketService.getTicketsByTicketOwner(id);
		if (null == result) {
			return ApiResponse.CreateError(null, TicketMessages.TICKET_UNSUCCESSFUL_GETALL);
		} else {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_SUCCESSFUL_GETALL);
		}
	}
	

	@PostMapping("/ticket/create")
	public ApiResponse createTicket(@RequestBody final Ticket ticket) {
	    Ticket savedTicket = ticketService.addTicket(ticket);
	    
	    if (null == savedTicket) {
			return ApiResponse.CreateError(null, TicketMessages.TICKET_UNSUCCESSFUL_ADD);
		} else {
			return ApiResponse.CreateSuccess(savedTicket, TicketMessages.TICKET_SUCCESSFUL_ADD);
		}
	    
	}


	@DeleteMapping("/ticket/delete/{id}")
	public ApiResponse deleteTicket(final @PathVariable int id) {
		Ticket result = ticketService.removeTicket(id);
		if (null == result) {
			return ApiResponse.CreateError(null, TicketMessages.TICKET_NOT_DELETED);
		} else {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_DELETED);
		}
	}

	@PutMapping("ticket/update/{id}")
	public ApiResponse updateTicket(final @PathVariable int id, @RequestBody Ticket ticket) {
		Ticket result = ticketService.updateTicket(id, ticket);
		if (null == result) {
			return ApiResponse.CreateError(null, TicketMessages.TICKET_UNSUCCESSFUL_UPDATE);
		} else {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_SUCCESSFUL_UPDATE);
		}

	}

}
