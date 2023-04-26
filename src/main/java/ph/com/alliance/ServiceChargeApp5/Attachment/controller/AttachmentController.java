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
	
	@GetMapping("/tickets/{id}/attachments")
	public ModelAndView execute()
	{
		return new ModelAndView(VIEW_PATH);
	}

	/**
	 * Process the file and upload it to the UPLOAD_PATH
	 * 
	 * @param request used to get the Part object
	 * @return ApiResponse whether it is successful or not
	 */
//	@PostMapping("/sampleupload")
//	public ApiResponse process(final HttpServletRequest request)
//	{
//		try {
//			final Part part = request.getPart("file");
//			part.write(UPLOAD_PATH.concat(getFileName(part)));
//			
//			return ApiResponse.CreateSuccess(null, "Success!");
//		} catch(final IOException | ServletException e) {
//			return ApiResponse.CreateError(null, "Generic message");
//		}
//	}
//	
//	@PostMapping("/ticket/{id}/attachments")
//	public ApiResponse uploadAttachment(@PathVariable("id") int ticketId, HttpServletRequest request) {
//	    try {
//	        final Part part = request.getPart("file");
//	        String fileName = getFileName(part);
//	        String filePath = UPLOAD_PATH + File.separator + fileName;
//	        part.write(filePath);
//	        attachmentService.saveAttachment(ticketId, fileName, filePath);
//	        return ApiResponse.CreateSuccess(null, "Attachment uploaded successfully!");
//	    } catch(final IOException | ServletException e) {
//	        return ApiResponse.CreateError(null, "Failed to upload attachment!");
//	    }
//	}
	
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
	                                     @RequestParam("file") MultipartFile file) {

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
	        attachment.setTicket(ticket);

	        attachmentService.saveAttachment(attachment);

	        Path uploadDir = Paths.get(UPLOAD_PATH + "/" + ticketId + "/" + attachment.getAttachment_id());
	        if (!Files.exists(uploadDir)) {
	            Files.createDirectories(uploadDir);
	        }

	        try (InputStream inputStream = file.getInputStream()) {
	            Path filePath = uploadDir.resolve(filename);
	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	        }

	        return ApiResponse.CreateSuccess(null, "Attachment uploaded successfully");
	    } catch (IOException ex) {
	        return ApiResponse.CreateError(null, "Failed to upload attachment");
	    }
	}
	
	/**
	 * Gets the filename from the Part object
	 * 
	 * @param part used to get the header content-disposition
	 * @return file name
	 */
//	private String getFileName(final Part part)
//	{
//		final String contentDisposition = part.getHeader("content-disposition");		
//		// Sample Content Disposition:form-data; name="file"; filename="attendance.png"
//
//		if (!contentDisposition.contains("filename=")) {
//			return null;
//		}
//		
//		final int beginIndex = contentDisposition.indexOf("filename=") + 10;
//		final int endIndex = contentDisposition.length() - 1;
//		
//		return contentDisposition.substring(beginIndex, endIndex);
//	}
}
