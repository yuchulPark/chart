package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.BookManager;
import com.example.demo.vo.BookVO;

@RestController
public class BookController2 {
	@RequestMapping(value="/getBook", produces="application/xml;charset=UTF-8")
	public String listBook() {
		/* getBook의 역할 : db에서 데이터를 가져와 다음과 같은 형태의 xml문서를 만들어서 제공함
		 getBook은 다음과 같은 순서로 진행됨. 1. 매개변수를 처리 -> db에서 데이터를 가져옴 -> 검색을 수행 -> xml문서를 만드는데 사용하는 변수를 선언 -> xml 문서를 만들고, return */
		// xml 만들기
		String str = "";
		str += "<rows>";
		str += "<page>1</page>";
		str += "<total>10</total>";
		str += "<records>15</records>";
		for(BookVO b : BookManager.listAll()) {
			str += "<row>";
			str += "<cell>"+b.getBookid()+"</cell>";
			str += "<cell>"+b.getBookname()+"</cell>";
			str += "<cell>"+b.getPublisher()+"</cell>";
			str += "<cell>"+b.getPrice()+"</cell>";
			str += "</row>";
		}
		str += "</rows>";
		return str;
	}
	// 추가, 삭제, 수정을 구분하려고 매개변수 oper를 전달. jq grid 플러그인은 데이터를 추가하거나 삭제, 수정하는 웹서비스를 하나만 선택함
	@RequestMapping("/updateBook")
	public String updateBook(BookVO b, String oper) {
		String str = "";
		System.out.println("oper : " + oper);
		System.out.println("책번호 : " + b.getBookid());
		if(oper.equals("add")) {
			BookManager.insertBook(b);
		}else if(oper.equals("edit")) {
			BookManager.updateBook(b);
		}else if(oper.equals("del")) {
			BookManager.deleteBook(b);
		}
		System.out.println("oper : " + oper);
		return str;
	}
}
