package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.AuthorDao;
import com.douzone.bookmall.vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
//		insertTest("김난도");
//		insertTest("천상병");
//		insertTest("조정래");
//		insertTest("원상병");
//		deleteTest((long) 3);
		updateTest("방시혁",(long)4);
		selectTest();

	}
	public static void insertTest(String name) {
		AuthorVo vo = new AuthorVo();
		vo.setName(name);
		
		new AuthorDao().insert(vo);
	}
	public static void selectTest() {
		List<AuthorVo> list = new AuthorDao().findAll();
		for (AuthorVo vo : list) {
			System.out.println(vo);
		}
	}
	public static void deleteTest(Long no) {
		AuthorVo vo = new AuthorVo();
		vo.setNo(no);
		new AuthorDao().delete(vo);
	}
	
	public static void updateTest(String name,Long no) {
		AuthorVo vo = new AuthorVo();
		vo.setName(name);
		vo.setNo(no);
		new AuthorDao().update(vo);
	}

}
