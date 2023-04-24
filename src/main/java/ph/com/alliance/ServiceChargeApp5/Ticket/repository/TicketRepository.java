package ph.com.alliance.ServiceChargeApp5.Ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ph.com.alliance.ServiceChargeApp5.Ticket.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer>{
	
	@Query("SELECT t FROM Ticket t WHERE t.ticket_status = :ticket_status")
	List<Ticket> findTicketsByStatus(@Param("ticket_status") String ticket_status);
	
	@Query("SELECT t FROM Ticket t JOIN FETCH t.ticket_owner_id u WHERE u.user_id = :user_id")
	List<Ticket> findTicketsByTicketOwner(@Param("user_id") int user_id);

	@Query("SELECT t FROM Ticket t JOIN FETCH t.ticket_assignee_id u WHERE u.user_id = :user_id")
	List<Ticket> findTicketsByTicketAssignee(@Param("user_id") int user_id);
	
	
	
	
}
