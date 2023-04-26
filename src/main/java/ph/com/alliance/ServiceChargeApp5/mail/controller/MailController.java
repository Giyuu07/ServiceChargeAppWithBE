package ph.com.alliance.ServiceChargeApp5.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.ServiceChargeApp5.common.component.EmailServiceComponent;


@RestController
public class MailController {
	
	// common
	private EmailServiceComponent mailComponent;
	
	@Autowired
	public MailController (final EmailServiceComponent mailComponent)
	{
		this.mailComponent = mailComponent;
	}

	@GetMapping("/test")
	public String sendMail()
	{
		return mailComponent.sendResetPasswordMessage("adrianson250@gmail.com","sampleToken");
	}
}
