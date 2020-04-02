package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.GoodsManager;
import com.example.demo.vo.ScheduleVO;
import com.google.gson.Gson;

@RestController
public class ScheduleController {
	@RequestMapping("/insertSchedule")
	public String insertSchedule(ScheduleVO s) {
		String str = "ok";
		GoodsManager.insertSchedule(s);
		return str;
	}
	@RequestMapping(value="/listSchedule", produces="application/json;charset=UTF-8")
	public String listSchedule() {
		return (new Gson()).toJson(GoodsManager.listSchedule());
	}
}
