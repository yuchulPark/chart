package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BookDAO;
import com.example.demo.vo.BookVO;
import com.google.gson.Gson;
@RestController
public class BookController {
	@Autowired
	private BookDAO dao;

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	@RequestMapping(value="/listBook.do", produces="application/json;charset=UTF-8")
	public String list() {
		String str = "";
		List<BookVO> list = dao.listAll();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
	@RequestMapping("/insertBook.do")
	public String insert(BookVO b) {
		String str = "ok";
		dao.insertBook(b);
		return str;
	}
	@RequestMapping("/updateBook.do")
	public String update(BookVO b) {
		String str = "ok";
		dao.updateBook(b);
		return str;
	}
	@RequestMapping("/deleteBook.do")
	public String delete(BookVO b) {
		String str = "ok";
		dao.deleteBook(b);
		return str;
	}
}
