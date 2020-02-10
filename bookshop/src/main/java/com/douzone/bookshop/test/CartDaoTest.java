package com.douzone.bookshop.test;

import java.util.List;

import com.douzone.bookshop.dao.CartDao;
import com.douzone.bookshop.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {

//		updateTest("성공",1L);
//		insertTest(1l,2l,3l);
//		deletTest(4L);
		

		findAllTest();

	}

	
	
	
	public static void findAllTest() {
		List<CartVo> list = new CartDao().findAll();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}
	
	
	public static void insertTest(Long no,Long bookNo,Long amount) {
		CartVo vo = new CartVo();
		vo.setNo(no);
		vo.setBookNo(bookNo);
		vo.setAmount(amount);
		new CartDao().insert(vo);
	}
	

	
	public static void deletTest(Long no) {
		CartVo vo = new CartVo();
		vo.setNo(no);
		new CartDao().delete(vo);
	}

}
