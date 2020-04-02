package com.example.demo.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

@RestController
public class MemberController2 {
	@Autowired
	private MemberDAO dao;
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	@Autowired
	private JavaMailSender mailSender;
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	@RequestMapping("/email3.do")
	public String mail(String in1) {
		Random rd = new Random();
		String r1 = "" + rd.nextInt(10);
		String r2 = "" + rd.nextInt(10);
		String r3 = "" + rd.nextInt(10);
		String r4 = "" + rd.nextInt(10);
		System.out.println(in1);
		
		mailSender.send(new MimeMessagePreparator(){
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				message.setFrom("468225@naver.com");
				message.setTo("pycupper@naver.com");
				message.setSubject("인증 번호");
				message.setText(r1 + r2 + r3 + r4);
			}
		});
		return r1+r2+r3+r4;
	}
	@RequestMapping("/insert.do")
	public String insert(MemberVO m) {
		String str = "";
		int re = dao.insertMember(m);
		if(re > 0) {
			str = "성공";
		}else {
			str = "실패";
		}
		return str;
	}
}
