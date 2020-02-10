package com.douzone.bookshop.test;

import java.util.List;

import com.douzone.bookshop.dao.MemberDao;
import com.douzone.bookshop.vo.MemberVo;


public class MemberDaoTest {

	public static void main(String[] args) {

//		updateTest("성공",1L);
//		insertTest("테스트","email","number","password");
//		deletTest(4L);
		

		findAllTest();

	}

	
	
	
	public static void findAllTest() {
		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
	}
	
	
	public static void insertTest(String name,String email,String number,String password) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setEmail(email);
		vo.setNumber(number);
		vo.setPassword(password);
		new MemberDao().insert(vo);
	}
	

	
	public static void deletTest(Long no) {
		MemberVo vo = new MemberVo();
		vo.setNo(no);
		new MemberDao().delete(vo);
	}

}
