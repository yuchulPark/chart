package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.CartVO;
import com.example.demo.vo.ChatVO;
import com.example.demo.vo.EmpVO;
import com.example.demo.vo.GoodsVO;
import com.example.demo.vo.MemberVO;
import com.example.demo.vo.ScheduleVO;

public class GoodsManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static List<GoodsVO> listAll(){
		SqlSession session = factory.openSession();
		List<GoodsVO> list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}
	public static List<ChatVO> listChat(){
		SqlSession session = factory.openSession();
		List<ChatVO> list = session.selectList("chat.selectAll");
		session.close();
		return list;
	}
	public static int insertChat(ChatVO vo) {
		SqlSession session = factory.openSession();
		int re = -1;
		re = session.insert("chat.insert", vo);
		session.commit();
		session.close();
		return re;
	}
	public static List<ScheduleVO> listSchedule(){
		SqlSession session = factory.openSession();
		List<ScheduleVO> list = session.selectList("schedule.selectAll");
		session.close();
		return list;
	}
	public static int insertSchedule(ScheduleVO s) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("schedule.insert", s);
		session.commit();
		session.close();
		return re;
	}
	public static int insertCart(CartVO c) {
		SqlSession session = factory.openSession();
		int re = -1;
		re = session.insert("cart.insert", c);
		session.commit();
		session.close();
		return re;
	}
	public static MemberVO isMember(MemberVO m) {
		SqlSession session = factory.openSession();
		MemberVO r = null;
		r = session.selectOne("member.isMember", m);
		session.close();
		return r;
	}
	public static List<EmpVO> listEmp(){
		SqlSession session = factory.openSession();
		List<EmpVO> list = session.selectList("emp.selectAll");
		session.close();
		return list;
	}
	public static int insertMember(MemberVO m) {
		SqlSession session = factory.openSession();
		int re = -1;
		re = session.insert("member.insert", m);
		session.commit();
		session.close();
		return re;
	}
}
