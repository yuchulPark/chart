package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.BookManager;
import com.example.demo.vo.BookVO;

@Repository
public class BookDAO {
	public List<BookVO> listAll(){
		return BookManager.listAll();
	}
	public int insertBook(BookVO b) {
		return BookManager.insertBook(b);
	}
	public int updateBook(BookVO b) {
		return BookManager.updateBook(b);
	}
	public int deleteBook(BookVO b) {
		return BookManager.deleteBook(b);
	}
}
