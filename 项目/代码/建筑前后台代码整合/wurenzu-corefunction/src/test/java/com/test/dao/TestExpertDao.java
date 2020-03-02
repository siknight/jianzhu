package com.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.run.CoreFunctionApplication;
import work.run.dao.ExpertDao;

@SpringBootTest(classes =CoreFunctionApplication.class)
@RunWith(SpringRunner.class)
public class TestExpertDao {
	@Autowired
	private ExpertDao expertdao;
	
	//用于测试查询所有专家 已测试正确6-22
	@Test
	public void test01() throws Exception {
		System.out.println(expertdao.findAll());
	}
	
	
	//用于测试查询单个专家详情 已测试正确6-22
	@Test
	public void test02() throws Exception {
		System.out.println(expertdao.findById(2));
	}
	
	//用于测试根据名称查询 已测试正确6-22
	@Test
	public void test03() throws Exception {
		System.out.println(expertdao.findByName("bb"));
	}
	
	//用于测试根据名称模糊查询 已测试正确6-22
	@Test
	public void test04() throws Exception {
		System.out.println(expertdao.findByNameLike("b"));
	}
	
	//用于测试根据id模糊查询 已测试正确6-22
	@Test
	public void test05() throws Exception {
		System.out.println(expertdao.findByIdLike(1));
	}

}
