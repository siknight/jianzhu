package com.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.run.CoreFunctionApplication;
import work.run.dao.ExpertScoreDao;

@SpringBootTest(classes =CoreFunctionApplication.class)
@RunWith(SpringRunner.class)
public class TestExpertScoreDao {
	@Autowired
	private ExpertScoreDao dao;
	
	//根据作品id 查询作品所有专家打分 已测试成功6-23
	@Test
	public void test01() throws Exception {
		Integer workid =1;
		System.out.println(dao.findAllByWorkId(workid));
	}
	//查询一个作品的最高分 已测试成功6-23
	@Test
	public void test02() throws Exception {
		Integer workid =1;
		System.out.println(dao.findOneMaxByWorkId(workid));
	}
	
	//查询一个作品的最低分 已测试成功6-23
	@Test
	public void test03() throws Exception {
		Integer workid =1;
		System.out.println(dao.findOneMinByWorkId(workid));
	}
	
	//查询一个作品的平均分 已测试成功6-23
	@Test
	public void test04() throws Exception {
		Integer workid =1;
		System.out.println(dao.findOneAverageByWorkId(1));
	}
}
