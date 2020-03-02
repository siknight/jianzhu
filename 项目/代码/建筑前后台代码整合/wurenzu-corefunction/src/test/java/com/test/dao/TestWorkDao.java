package com.test.dao;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.run.CoreFunctionApplication;
import work.run.dao.WorkDao;

@SpringBootTest(classes =CoreFunctionApplication.class)
@RunWith(SpringRunner.class)
public class TestWorkDao {
	@Autowired
	private WorkDao dao;
	
	//提交作品,期数必须是最新的 已测试成功6-23
	@Test
	public void test01() throws Exception {
		String workname = "aa";
		String imgUrl = "c.png";
		Integer firmUserid = 1;  
		String details = "aaaa";
		Integer period = 1;
		System.out.println(dao.insert(workname,imgUrl,firmUserid,details,period));
		
	}
	
	//根据 期数 查询所有参赛作品 已测试成功6-23
	@Test
	public void test02() throws Exception {
		Integer period =2;
		System.out.println(dao.findAllByPeriod(period ));
	}
	
	 //查询最新期的参赛作品 已测试成功6-23
	@Test
	public void test03() throws Exception {
		System.out.println(dao.findAllByMaxPeriod());
	}
	
	//根据用户id查询参赛作品 已测试成功6-23
	@Test
	public void test04() throws Exception {
		Integer firmUserid =2;
		System.out.println(dao.findAllByFirmUserId(firmUserid));
	}
	
	//根据 期数 查询排名前几  已测试成功6-23
	@Test
	public void test05() throws Exception {
		Integer period =1;
		Integer number =2;
		System.out.println(dao.findWinByPeriod(period,number));
	}
	
	 //查询展品 已测试成功6-23
	@Test
	public void test06() throws Exception {
		System.out.println(dao.findAllExhibits());
	}
	
	
	//查询 每期 排名 前三的参赛作品
	@Test
	public void test07() throws Exception {
		System.out.println(dao.findAllWinByPeriodRank());
	}
	
	@Test
	public void test08() throws Exception {
		System.out.println(dao.findAll());
	}
	
	
	

}
