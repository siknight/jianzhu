package com.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.run.CoreFunctionApplication;
import work.run.service.ExpertService;

@SpringBootTest(classes =CoreFunctionApplication.class)
@RunWith(SpringRunner.class)
public class TestExpertService {
	@Autowired
	private ExpertService service;
	
	//查询所有的专家 已测试成功6-22
	@Test
	 public void test01() throws Exception {
		System.out.println(service.showAllExpert());
	}
	
	//根据id 查询单个专家详情 已测试成功6-22
	@Test
	 public void test02() throws Exception {
		System.out.println(service.showAllExpertByid(2));
	}
	
	//根据名称查询 已测试成功6-22
	@Test
	 public void test03() throws Exception {
		 System.out.println(service.showAllExpertByName("bb"));
		
	}
	
	//根据名称模糊查询 已测试成功6-22
	@Test
	 public void test04() throws Exception {
		System.out.println(service.showExpertByNameLike("b"));
	}
	
	//根据id 模糊查询 已测试成功6-22
	@Test
	 public void test05() throws Exception {
		System.out.println(service.showExpertByIdLike(1));
	}

}
