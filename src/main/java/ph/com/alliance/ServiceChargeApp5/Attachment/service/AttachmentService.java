package ph.com.alliance.ServiceChargeApp5.Attachment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ph.com.alliance.ServiceChargeApp5.Attachment.entity.Attachment;

@Service
public interface AttachmentService {

	 //SAVE
	 Attachment saveAttachment(Attachment attachment);
	 
	 //GET 
	 List<Attachment> getAttachments();
	 List<Attachment> getAttachmentsByTicketId(int ticketId);


}
