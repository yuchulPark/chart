package com.example.demo.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.EmpDAO;
import com.example.demo.vo.EmpVO;

@Controller
public class EmpController {
	@Autowired
	private EmpDAO dao;
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	@Autowired
	private JavaMailSender mailSender;
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	@RequestMapping("/emp.do")
	public void mail() {
		List<EmpVO> list = dao.listEmp();
		for(EmpVO e : list) {
			mailSender.send(new MimeMessagePreparator(){
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					message.setFrom("468225@naver.com");
					message.setSubject("복습중입니다 알림 미안합니다");
					message.setTo(e.getEmail());
					String str = "복습 성공 <br>" + e.getEname() + "님 수고하셨습니다.<br>" + "월급과 상여금은 다음과 같습니다.<br>" + "월급 : " + e.getSal() + "만원, 상여금 : " + e.getComm() + "만원";
					message.setText(str);
					message.addInline("dobby", new ClassPathResource("static/dobby.jpg"));
					message.addAttachment("wow.html", new ClassPathResource("static/wow.html"));
				}
			});
		}
	}
}
