package com.aia.firstspring.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	public boolean simpleMailSend() {
		boolean result = true;

		SimpleMailMessage message = new SimpleMailMessage();
		// SimpleMailMessage message = new SimpleMailMessage(templateMessage);
		message.setTo("hyein4coding@gmail.com");
		message.setSubject("테스트 이메일");
		message.setText("본문");

		try {
			mailSender.send(message);
		} catch (MailException e) {
			result = false;
		}

		return result;

	}

	public boolean mailSend(String toEmailAddress) {
		boolean result = true;
		MimeMessage message = mailSender.createMimeMessage();
		try {
			// 메일 제목
			message.setSubject("[안내]회원 ㅊㅋㅊㅋ", "utf-8");
			// 메일에 적용할 html의 내용
			String htmlStr = "<h1>회원 가입을 축하합니다.</h1>";
			// 메일 내용
			message.setText(htmlStr, "utf-8", "html");
			// 보내는 사람의 이메일 : gmail의 경우에는 인증된 메일로 적용된다.
			message.setFrom(new InternetAddress("hyein4coding@gmail.com"));
			// 받는 사람의 이메일 주소
			message.addRecipient(RecipientType.TO, new InternetAddress(toEmailAddress, "최혜인 고객님"));
			// 메일 전송
			mailSender.send(message);
		} catch (MessagingException e) {
			result = false;
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}


	/*
	 * param@ toEmailAddress : 보내는 사람의 이메일
	 * param@ name : 받는 사람의 이름
	 * param@ subject :  메일의 제목
	 * param@ text : 메일 내용
	 */
	
	public boolean mailSend(String toEmailAddress, String name, String subject, String text) {
		boolean result = true;
		MimeMessage message = mailSender.createMimeMessage();
		try {
			// 메일 제목
			message.setSubject(subject, "utf-8");
			// 메일에 적용할 html의 내용
			// String htmlStr = "<h1>회원 가입을 축하합니다.</h1>";
			// 메일 내용
			message.setText(text, "utf-8", "html");
			// 보내는 사람의 이메일 : gmail의 경우에는 인증된 메일로 적용된다.
			message.setFrom(new InternetAddress("hyein4coding@gmail.com"));
			// 받는 사람의 이메일 주소
			message.addRecipient(RecipientType.TO, new InternetAddress(toEmailAddress, name+" 고객님"));
			// 메일 전송
			mailSender.send(message);
		} catch (MessagingException e) {
			result = false;
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}

}
