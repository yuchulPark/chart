package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.GoodsManager;
import com.example.demo.vo.MemberVO;

@RestController
public class MemberController {
	@RequestMapping("/login")
	public String login(MemberVO m) {
		String str = "no";
		MemberVO r = GoodsManager.isMember(m);
		System.out.println(r);
		if(r != null) {
			System.out.println("성공");
			str = m.getId();
		}else {
			System.out.println("실패");
		}
		System.out.println("결과 : " + str);
		return str;
	}
}
