package ph.com.alliance.ServiceChargeApp5.Ticket.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ph.com.alliance.ServiceChargeApp5.Ticket.entity.Ticket;
import ph.com.alliance.ServiceChargeApp5.Ticket.repository.TicketRepository;
import ph.com.alliance.ServiceChargeApp5.User.entity.User;
import ph.com.alliance.ServiceChargeApp5.User.repository.UserRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
	private TicketRepository ticketRepository;
	private UserRepository userRepository;
	
	@Autowired
	public TicketServiceImpl(final TicketRepository ticketRepository, final UserRepository userRepository)
	{
		this.ticketRepository = ticketRepository;
		this.userRepository = userRepository;
	}

	public Ticket getTicketById(int id) {
		final Optional<Ticket> ticket = ticketRepository.findById(id);
		return ticket.orElse(null);
	}

	public List<Ticket> getAllTickets() {
		final List<Ticket> ticketList = ticketRepository.findAll();
		return ticketList != null ? ticketList : null;
	}

	public List<Ticket> getTicketsByStatus(String status) {
		final List<Ticket> ticketList = ticketRepository.findTicketsByStatus(status);
		return ticketList != null ? ticketList : null;
	}

	public Ticket addTicket(Ticket ticket) {
		 User ticketOwner = userRepository.findById(ticket.getTicket_owner_id().getUser_id())
		            .orElseThrow(() -> new RuntimeException("Owner not found"));
//		    User ticketAssignee = userRepository.findById(ticket.getTicket_assignee_id().getUser_id())
//		            .orElseThrow(() -> new RuntimeException("Assignee not found"));

		    // create new ticket entity and set its properties
		    Ticket newTicket = new Ticket();
		    newTicket.setTicket_title(ticket.getTicket_title());
		    newTicket.setTicket_description(ticket.getTicket_description());
		    newTicket.setTicket_status(ticket.getTicket_status());
		    newTicket.setDate_created(LocalDateTime.now());
		    newTicket.setTicket_owner_id(ticketOwner);
//		    newTicket.setTicket_assignee_id(ticketAssignee);

		    // save the new ticket entity to the database using a ticket repository
		return ticketRepository.saveAndFlush(newTicket);

	}


	public Ticket removeTicket(int id) {	
		    Optional<Ticket> ticket = ticketRepository.findById(id);
		    if (ticket.isPresent()) {
		    	ticketRepository.deleteById(id);
		        return ticket.get();
		    } else {
		        return null;

		    }
	}

	public Ticket updateTicket(int id, Ticket ticket) {
		Optional<Ticket> existingTicket = ticketRepository.findById(id);
	    if (existingTicket.isPresent()) {
	    	ticket.setTicket_id(id);
	        Ticket result = ticketRepository.saveAndFlush(ticket);
	        return result;
	    } else {
	        return null;
	    }
	}

	public List<Ticket> getTicketsByTicketOwner(int id) {
		final List<Ticket> ticketList = ticketRepository.findTicketsByTicketOwner(id);
		return ticketList != null ? ticketList : null;
	}


	public List<Ticket> getTicketsByTicketAssignee(int id) {
		final List<Ticket> ticketList = ticketRepository.findTicketsByTicketAssignee(id);
		return ticketList != null ? ticketList : null;
	}

}
