package com.test;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.run.UserApplication;
import work.run.dao.UserDao;
import work.run.pojo.User;
import work.run.service.UserService;
import work.run.util.Result;



@SpringBootTest(classes =UserApplication.class)
@RunWith(SpringRunner.class)
public class TestUser {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	UserDao dao;
	
	@Autowired
	UserService service;
	
	
	
	@Test
	public void test01() throws Exception {
		System.out.println(datasource.getConnection());
	}
	
	//测试 查询
	@Test
	public void test02() throws Exception {
		//User user = dao.findUserByName("jiang");
		User user = dao.findUserById(37);
		System.out.println(user);
	}
	
	//测试 写操作
	@Test
	public void test03() throws Exception {
		//int i = dao.insert("rr", "rr","rr");
		//int i = dao.updatePassById("cc","cc", 1);
		int i = dao.updateAllOutPass(null, null, "cc", "cc", "ss", "dd", 1);
		System.out.println(i);
	}
	
	@Test
	public void test05() throws Exception {
		
		Result result = service.addUser("lily123", "lily123");
		System.out.println(result);
	}
	
	@Test
	public void test06() throws Exception {
		Result result = service.login("lily123", "lily123");
		System.out.println(result);
	}
	
	@Test
	public void test04() throws Exception {
		//Result result = service.updatePassbyId("ss", 1);
		Result result = service.updateAllOutPass("bb", "bb",  null, null, "aa", null, 1);
		System.out.println(result);
	}

}
