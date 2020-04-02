package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BookVO;

public class BookManager {
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
	public static List<BookVO> listAll(){
		SqlSession session = factory.openSession();
		List<BookVO> list = session.selectList("book.selectAll");
		session.close();
		return list;
	}
	public static int insertBook(BookVO b) {
		SqlSession session = factory.openSession();
		int re = session.insert("book.insert", b);
		session.commit();
		session.close();
		return re;
	}
	public static int updateBook(BookVO b) {
		SqlSession session = factory.openSession();
		int re = session.update("book.update", b);
		session.commit();
		session.close();
		return re;
	}
	public static int deleteBook(BookVO b) {
		SqlSession session = factory.openSession();
		int re = session.delete("book.delete", b);
		session.commit();
		session.close();
		return re;
	}
}
