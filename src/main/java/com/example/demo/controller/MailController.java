package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {
	@Autowired
	private MailSender javaMailSender;
	public void setJavaMailSender(MailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	@RequestMapping("/email.do")
	public String mail() {
		String str = "";
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject("안녕하세요.");
		mailMessage.setFrom("468225@naver.com");
		mailMessage.setText("블랑카입니다.");
		mailMessage.setTo("pycupper@naver.com");
		try {
			javaMailSender.send(mailMessage);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	@RequestMapping("/login.do")
	public String login(String email) {
		int ran = (int)Math.ceil(Math.random() * 10000); // 이렇게 하면 0부터 9999가 나오니 각각 한자리수로 4개가 나오도록 해야함
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject("인증 절차입니다.");
		mailMessage.setFrom("468225@naver.com");
		mailMessage.setTo(email);
		mailMessage.setText("" + ran);
		try {
			javaMailSender.send(mailMessage);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "" + ran;
	}
}
