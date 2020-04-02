package com.example.demo.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController2 {
	@Autowired
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	@RequestMapping("/email2.do")
	public void mail() {
		mailSender.send(new MimeMessagePreparator(){
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				message.setFrom("468225@naver.com");
				message.setTo("pycupper@naver.com");
				message.setSubject("안녕하세요2");
				String str = "<h1>블랑카입니다2</h1>";
				str += "<img src='cid:ff'>";
				message.setText(str, true);
				message.addInline("ff", new ClassPathResource("static/ff.jpeg"));
				message.addAttachment("index2.html", new ClassPathResource("static/index2.html"));
			}
		});
	}
}
