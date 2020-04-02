package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.GoodsManager;
import com.example.demo.vo.ChatVO;
import com.google.gson.Gson;

@RestController
public class ChatController {
	@RequestMapping(value="/chatList", produces="application/json;charset=UTF-8")
	public String chatList() {
		return (new Gson()).toJson(GoodsManager.listChat());
	}
	@RequestMapping("/chatInsert")
	public String insertChat(ChatVO vo) {
		String str = "ok";
		GoodsManager.insertChat(vo);
		return str;
	}
}
