package ph.com.alliance.ServiceChargeApp5.Attachment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ph.com.alliance.ServiceChargeApp5.Attachment.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
	
	@Query("SELECT a FROM Attachment a JOIN FETCH a.ticket t WHERE t.ticket_id = :ticket_id")
	List<Attachment> findAttachmentsByTicketId(@Param("ticket_id") int ticket_id);

}
