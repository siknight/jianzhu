package com.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.run.CoreFunctionApplication;
import work.run.dao.FirmUserDao;

@SpringBootTest(classes =CoreFunctionApplication.class)
@RunWith(SpringRunner.class)
public class TestFirmUserDao {
	@Autowired
	private FirmUserDao firmuserdao;
	
	//根据name 查询参赛者信息 已测试成功6-22
	@Test 
	public void test01() throws Exception {
		System.out.println(firmuserdao.findUserByName("lilu"));
	}
	
	//根据id 查询参赛者信息 已测试成功6-22
	@Test
	public void test02() {
		System.out.println(firmuserdao.findUserById(49));
		
	}
	
	//根据 期数 查询参赛者 已测试成功6-22
	@Test
	public void test03() throws Exception {
		System.out.println(firmuserdao.findAllByPeriod(1));
	}
	
	//查询最新一期的参赛者 已测试成功6-22
	@Test
	public void test04() throws Exception {
		System.out.println(firmuserdao.findAllByMaxPeriod());
	}
	
	 //根据name 模糊查询 某期的参赛者 已测试成功6-22
	@Test
	public void test05() throws Exception {
		System.out.println(firmuserdao.findByNameLike("li", 2));
	}
	
	//根据name 模糊查询 最新期的参赛者 已测试成功6-22
	@Test
	public void test06() throws Exception {
		System.out.println(firmuserdao.findByNameMaxPeriod("l"));
	}
	
	//根据公司名 模糊查询 最新期的参赛者 已测试成功6-22
	@Test
	public void test07() throws Exception {
		System.out.println(firmuserdao.findByFirmMaxPeriod("a"));
	}
	
	//根据公司名 模糊查询 某期的参赛者 已测试成功6-22
	@Test
	public void test08() throws Exception {
		System.out.println(firmuserdao.findByFirmPeriod("a", 1));
	}
	
	//查询某期最高分的参赛者 已测试成功6-22
	@Test
	public void test09() throws Exception {
		System.out.println(firmuserdao.findByPeriodMaxScore(1));
	}
	
	//查询前几期最高分的参赛者 已测试成功6-22
	@Test
	public void test10() throws Exception {
		System.out.println(firmuserdao.findBySomePeriodMaxScore(2));
	}
	
	//查询每期最高分的参赛者 已测试成功6-22
	@Test
	public void test11() throws Exception {
		System.out.println(firmuserdao.findbyAllPeriodMaxScore());
	}
	
}
