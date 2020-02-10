package com.douzone.bookshop.test;

import java.util.List;

import com.douzone.bookshop.dao.OrderDao;
import com.douzone.bookshop.vo.OrderBookVo;
import com.douzone.bookshop.vo.OrderVo;


public class OrderDaoTest {

	public static void main(String[] args) {

//		updateTest("성공",1L);
//		insertTest(7000l,"주소",2l);
//		deletTest(3L);
		
		findAllTest();

	}

	
	public static void findAllTest() {
		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			List<OrderBookVo> list2 = new OrderDao().findBook(vo.getNo());
			System.out.println(vo);
			for(OrderBookVo vo2 : list2) {
				System.out.println(vo2);
			}
		}
	}
	
	
	
	public static void insertTest(Long price,String address,Long memberNo) {
		OrderVo vo = new OrderVo();
		vo.setPrice(price);
		vo.setAddress(address);
		vo.setMemberNo(memberNo);
		new OrderDao().insert(vo);
	}
	

	
	public static void deletTest(Long no) {
		OrderVo vo = new OrderVo();
		vo.setNo(no);
		new OrderDao().delete(vo);
	}
	
	


}
