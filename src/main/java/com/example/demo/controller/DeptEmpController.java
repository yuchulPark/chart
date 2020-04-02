package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DeptEmpManager;
import com.example.demo.vo.DeptEmpVO;
import com.google.gson.Gson;

@RestController
public class DeptEmpController {
	@RequestMapping(value="/cnt", produces="application/json; charset=UTF-8")
	public String listCnt() {
		String str = "";
		List<DeptEmpVO> list = DeptEmpManager.listCnt();
		Gson gson = new Gson();
		str = gson.toJson(list);
		return str;
	}
}
