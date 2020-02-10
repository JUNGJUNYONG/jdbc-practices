package com.douzone.bookshop.test;

import java.util.List;

import com.douzone.bookshop.dao.CategoryDao;
import com.douzone.bookshop.vo.CategoryVo;


public class CategoryDaoTest {

	public static void main(String[] args) {

//		updateTest("성공",1L);
//		insertTest("테스트중");
//		deletTest(4L);
		

		findAllTest();

	}

	
	
	
	public static void findAllTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
	
	
	public static void insertTest(String category) {
		CategoryVo vo = new CategoryVo();
		vo.setCategory(category);
		
		new CategoryDao().insert(vo);
	}
	

	
	public static void deletTest(Long no) {
		CategoryVo vo = new CategoryVo();
		vo.setNo(no);
		new CategoryDao().delete(vo);
	}

}
