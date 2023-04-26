package ph.com.alliance.ServiceChargeApp5.fileupload.controller;

//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.Part;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import ph.com.alliance.ServiceChargeApp5.common.models.ApiResponse;

//@RestController
//@MultipartConfig(
//		maxFileSize = 1024 * 1024 * 40, // 40 MB
//		maxRequestSize = 1024 * 1024 * 30 // 30 MB
//		)
public class FileUploadController {
//	/**
//	 * View name
//	 */
//	public static final String VIEW_PATH = "/uploadFile.html";
//	
//	/**
//	 * Upload path
//	 */
//	public static final String UPLOAD_PATH = "/Users/adrianson/Desktop/JumpstartAllianceUploadFolder/";
//	
//	/**
//	 * To get the page (NOT NECESSARY IF YOU HAVE ANOTHER WAY OF DISPLAYING YOUR FRONT-END)
//	 * 
//	 * @return ModelAndView
//	 */
//	@GetMapping("/sampleupload")
//	public ModelAndView execute()
//	{
//		return new ModelAndView(VIEW_PATH);
//	}
//	
//	/**
//	 * Process the file and upload it to the UPLOAD_PATH
//	 * 
//	 * @param request used to get the Part object
//	 * @return ApiResponse whether it is successful or not
//	 */
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
//	
//	/**
//	 * Gets the filename from the Part object
//	 * 
//	 * @param part used to get the header content-disposition
//	 * @return file name
//	 */
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
