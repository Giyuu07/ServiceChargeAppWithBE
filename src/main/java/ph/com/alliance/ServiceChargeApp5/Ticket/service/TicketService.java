package ph.com.alliance.ServiceChargeApp5.Ticket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ph.com.alliance.ServiceChargeApp5.Ticket.entity.Ticket;

@Service
public interface TicketService {
	Ticket getTicketById(int id);
	List<Ticket> getAllTickets();
	
	List<Ticket> getTicketsByStatus(String status);
	List<Ticket> getTicketsByTicketOwner(int id);
	List<Ticket> getTicketsByTicketAssignee(int id);
	
	Ticket addTicket(final Ticket ticket);
	Ticket removeTicket(int id);
	Ticket updateTicket(int id, Ticket ticket);
}
