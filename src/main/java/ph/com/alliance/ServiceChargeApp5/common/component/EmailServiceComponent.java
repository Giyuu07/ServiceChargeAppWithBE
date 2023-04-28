package ph.com.alliance.ServiceChargeApp5.common.component;


import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceComponent
{
	
    private JavaMailSender emailSender;
	
	@Autowired
	public EmailServiceComponent(final JavaMailSender emailSender)
	{
		this.emailSender = emailSender;
	}
	
	public String sendResetPasswordMessage(String recipientEmail, String resetToken) {
	    final String emailFrom = "servicecharge@noreply.com";
	    final String emailSubject = "Password Reset Request";
	    final String emailBody = "Dear User,\n\nYou have requested to reset your password. Please copy the token and paste it to proceed with password change:\n\n"
	                             + "Token: " + resetToken + "\n\n"
	                             + "If you did not request this reset, please ignore this message.\n\n"
	                             + "Best regards,\nYour Service Charge Team";
	                             
	    final SimpleMailMessage message = new SimpleMailMessage();
	    message.setFrom(emailFrom);
	    message.setTo(recipientEmail);
	    message.setSubject(emailSubject);
	    message.setText(emailBody);
	    emailSender.send(message);

	    return "Success!";
	}

	
	public String sendMessageWithAttachment(
	  String to, String subject, String text, String pathToAttachment) {
	    
		final MimeMessage message = emailSender.createMimeMessage();
	    
	    try { 
	    	final MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    
	    	helper.setFrom("testmail@gmail.com");
	    	helper.setTo("testmail@gmail.com");
	    	helper.setSubject(subject);
	    	helper.setText(text);
//	    	D:Localfiles
	    	final FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
	    	helper.addAttachment("Invoice", file);
	    } catch (final MessagingException e) {
	    	return "Error occured." + e.getMessage();
	    }

	    emailSender.send(message);
	    
	    return "Success!";
	}
}

