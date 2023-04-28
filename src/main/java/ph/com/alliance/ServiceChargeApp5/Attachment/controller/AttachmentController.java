package ph.com.alliance.ServiceChargeApp5.Attachment.controller;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ph.com.alliance.ServiceChargeApp5.Attachment.entity.Attachment;
import ph.com.alliance.ServiceChargeApp5.Attachment.service.AttachmentService;
import ph.com.alliance.ServiceChargeApp5.Ticket.Messages.TicketMessages;
import ph.com.alliance.ServiceChargeApp5.Ticket.entity.Ticket;
import ph.com.alliance.ServiceChargeApp5.Ticket.repository.TicketRepository;
import ph.com.alliance.ServiceChargeApp5.common.models.ApiResponse;



@RestController
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 40, // 40 MB
		maxRequestSize = 1024 * 1024 * 30 // 30 MB
		)
public class AttachmentController {
	public static final String VIEW_PATH = "/uploadFile.html";
	/**
	 * Upload path
	 */
	public static final String UPLOAD_PATH = "/Users/adrianson/Desktop/JumpstartAllianceUploadFolder/";
	
	private AttachmentService attachmentService;
	private TicketRepository ticketRepository;

	@Autowired
	public AttachmentController(AttachmentService attachmentService, TicketRepository ticketRepository) {
		super();
		this.attachmentService = attachmentService;
		this.ticketRepository = ticketRepository;
	}
	
	
	@GetMapping("/ticket/attachments")
	public ApiResponse getAttachments() {
		List<Attachment> result = attachmentService.getAttachments();
		if (null == result) {
			return ApiResponse.CreateError(null, TicketMessages.TICKET_UNSUCCESSFUL_GETALL);
		} else {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_SUCCESSFUL_GETALL);
		}
	}
	
	@GetMapping("/attachments/tickets")
	public ApiResponse getAttachmentsByTicketID(final @RequestParam int ticketId) {
		List<Attachment> result = attachmentService.getAttachmentsByTicketId(ticketId);
		if (null == result) {
			return ApiResponse.CreateError(null, TicketMessages.TICKET_UNSUCCESSFUL_GETALL);
		} else {
			return ApiResponse.CreateSuccess(result, TicketMessages.TICKET_SUCCESSFUL_GETALL);
		}
	}
	
	@PostMapping("/tickets/{id}/attachments")
	public ApiResponse uploadAttachment(@PathVariable("id") int ticketId,
	                                     @RequestParam("file") MultipartFile file,  @RequestParam("file_category") String fileCategory) {

	    Ticket ticket = ticketRepository.findById(ticketId)
	            .orElseThrow();

	    try {
	        String filename = StringUtils.cleanPath(file.getOriginalFilename());
	        byte[] fileData = file.getBytes(); // read bytes from uploaded file
	        String fileType = file.getContentType(); // get file type from uploaded file
	        Attachment attachment = new Attachment();
	        attachment.setFile_name(filename);
	        attachment.setFile_data(fileData);
	        attachment.setFile_type(fileType);
	        attachment.setFile_category(fileCategory); // set the file category

	        attachment.setTicket(ticket);

	        attachmentService.saveAttachment(attachment);

	        Path uploadDir = Paths.get(UPLOAD_PATH + "/" + ticketId + "/" + fileCategory + "/" + attachment.getAttachment_id());
	        if (!Files.exists(uploadDir)) {
	            Files.createDirectories(uploadDir);
	        }

	        try (InputStream inputStream = file.getInputStream()) {
	            Path filePath = uploadDir.resolve(filename);
	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	            attachment.setFile_url(filePath.toUri().toString());
	            attachmentService.saveAttachment(attachment);
	        }

	        return ApiResponse.CreateSuccess(null, "Attachment uploaded successfully");
	    } catch (IOException ex) {
	        return ApiResponse.CreateError(null, "Failed to upload attachment");
	    }
	}


}
