package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.GoodsManager;
import com.example.demo.vo.CartVO;

@RestController
public class CartController {
	@RequestMapping("/insertCart")
	public String insertCart(CartVO c) {
		String str = "ok";
		GoodsManager.insertCart(c);
		System.out.println("장바구니에 담긴 번호 : " + c.getGno());
		return str;
	}
}
