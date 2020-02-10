package com.douzone.bookshop.test;

import java.util.List;

import com.douzone.bookshop.dao.BookDao;
import com.douzone.bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		
//		updateTest("성공",1L);
//		insertTest("책분류3","책임니다",5900L);
//		deletTest(4L);
		
		findAllTest();

	}
	
	public static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	
	public static void insertTest(String category,String title,Long price) {
		BookVo vo = new BookVo();
		vo.setCategory(category);
		vo.setTitle(title);
		vo.setPrice(price);
		new BookDao().insert(vo);
	}
	
	public static void updateTest(String title,Long no) {
		BookVo vo = new BookVo();
		
		vo.setTitle(title);
		vo.setNo(no);
		new BookDao().update(vo);
	}
	
	public static void deletTest(Long no) {
		BookVo vo = new BookVo();
		vo.setNo(no);
		new BookDao().delete(vo);
	}
	

}
