package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GoodsDAO;
import com.google.gson.Gson;

@RestController
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	
	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	@RequestMapping(value="/goodsList", produces="application/json;charset=UTF-8")
	public String goodsList() {
		return (new Gson()).toJson(dao.listAll());
	}
}
