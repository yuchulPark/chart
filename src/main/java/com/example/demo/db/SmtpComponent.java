package com.example.demo.db;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class SmtpComponent {
	@Bean
	public JavaMailSenderImpl javaMailSender() {
		JavaMailSenderImpl r = new JavaMailSenderImpl();
		r.setHost("smtp.naver.com");
		r.setPort(587);
		r.setUsername("468225");
		r.setPassword("s364248s!!@@");
		r.setDefaultEncoding("UTF-8");
		
		Properties p = new Properties();
		p.put("mail.smtp.starttls.enable", true);
		p.put("mail.smtp.auth", true);
		p.put("mail.smtp.ssl.checkserveridentity", true);
		p.put("mail.smtp.ssl.trust", "*");
		r.setJavaMailProperties(p);
		return r;
	}
}
