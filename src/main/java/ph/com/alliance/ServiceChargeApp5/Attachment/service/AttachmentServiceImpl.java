package ph.com.alliance.ServiceChargeApp5.Attachment.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.alliance.ServiceChargeApp5.Attachment.entity.Attachment;
import ph.com.alliance.ServiceChargeApp5.Attachment.repository.AttachmentRepository;


@Service
public class AttachmentServiceImpl implements AttachmentService {

	
	private AttachmentRepository attachmentRepository;
	
	
	
	@Autowired
	public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
		super();
		this.attachmentRepository = attachmentRepository;
	}

	@Override
	public Attachment saveAttachment(Attachment attachment) {
		Attachment result = attachmentRepository.save(attachment);
		return result;
	}

	@Override
	public List<Attachment> getAttachmentsByTicketId(int ticketId) {
		final List<Attachment> result = attachmentRepository.findAttachmentsByTicketId(ticketId);
		return result != null ? result : Collections.emptyList();
	}

//	@Override
	public List<Attachment> getAttachments() {
		final List<Attachment> result = attachmentRepository.findAll();
		return result != null ? result : Collections.emptyList();
	}

}
