package com.aia.firstspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.firstspring.service.MailSenderService;

@Controller
@RequestMapping("/mail")
public class MailSenderController {

	@Autowired
	MailSenderService mailSenderService;
	
	
//	@Autowired
//	private JavaMailSender mailSender;
//	
//	@Autowired
//	private SimpleMailMessage templateMessage;
	
	@RequestMapping("/simplemail")  //  /mail/simplemail -> void하면 /mail이라는 폴더 안에 simplemail을 찾는다.(자동으로 경로를 찾음)
	public void simpleMailSend() {
	
		// mailSenderService.simpleMailSend();
		mailSenderService.mailSend("hyein4coding@gmail.com");
		
		
	// return  "/mail/simplemail";
	}
	
}
