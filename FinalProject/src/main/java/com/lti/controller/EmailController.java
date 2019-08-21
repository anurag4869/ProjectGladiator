package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {


		@Autowired
		private MailSender mailSender;
		
		@Autowired
		private SimpleMailMessage message;
		
		@GetMapping("/sendEmail.lti")
		public void send(@RequestParam("email") String email,@RequestParam("content") String content){
			
			message.setTo(email); //set a proper recipient of the mail
			message.setSubject("Exam Corner Test Results");
			message.setText("Your Score is "+content);
			mailSender.send(message);
			
		}
		
	}

