package com.example.demo.email;

import java.lang.System.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{

	private final JavaMailSender mailSender;
	private final static org.slf4j.Logger LOGGER =  LoggerFactory
			.getLogger(EmailService.class);
	
	@Override
	@Async
	public void send(String to, String email) {
		System.out.println("Start Sending");
		try { 
			MimeMessage mimeMessage =  mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
			helper.setText(email, true);
			helper.setTo(to);
			helper.setSubject("Confirm your email");
			helper.setFrom("nguyenhoanganhgoahead@gmail.com");
			mailSender.send(mimeMessage);
		}catch(MessagingException e){
			 LOGGER.error("fail to send emai; ", e);
			throw new IllegalStateException("failed to send email");
		}
		
	}

}
