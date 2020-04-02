package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.GoodsManager;
import com.example.demo.vo.MemberVO;

@Repository
public class MemberDAO {
	public int insertMember(MemberVO m) {
		return GoodsManager.insertMember(m);
	}
}
