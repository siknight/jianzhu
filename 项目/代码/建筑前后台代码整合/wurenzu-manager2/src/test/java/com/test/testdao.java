package com.test;

import static org.junit.Assert.*;

import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.run.ManagerApplication;
import work.run.dao.FirmUserdao;
import work.run.dao.ManagerDao;
import work.run.dao.MenuDao;
import work.run.dao.RedisDao;
import work.run.pojo.Firmuser;
import work.run.pojo.Manager;
import work.run.service.ExpertService;
import work.run.service.ManagerService;
import work.run.service.MenuService;
import work.run.service.RaceService;
import work.run.service.RoleService;
import work.run.service.WorkService;

import work.run.util.Result;



@SpringBootTest(classes =ManagerApplication.class)
@RunWith(SpringRunner.class)
public class testdao {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	ManagerDao dao;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	ManagerService service;
	
	@Autowired
	FirmUserdao firmUserDao;
	
	@Autowired
	RaceService raceService;
	
	
	@Autowired
	WorkService workservice;
	
	/**
	 * 添加redis 的类有ExpertService的查询专家，ManagerService里的登录，MenuService里的查询菜单，Race里的查询历史比赛和查询比赛
	 */
	@Autowired
	RedisDao redisDao;
	
	
	@Test
	public void test_redis() throws Exception {
//		redisDao.saveObject("a", "a hello jiang");
//		System.out.println(redisDao.getObject("a"));
		//sredisDao.removeObject("");
		redisDao.removeObject("selectExportByRoleId2");  //移除redis缓存
		//redisDao.removeObject("loginRedis"+manager.getName());
		
	}
	
	
	@Test
	public void test_workservice2() throws Exception {
		//workservice.findAllWorkRankByStatusAndPage(1,1);
	}
	
	@Test
	public void test_workservice() throws Exception {
		Result result = workservice.findAllWorkByStatus(1);
		System.out.println(result);
	}
	
	
	@Test
	public void test_raceService() throws Exception {
		RaceService service2 = new RaceService();
		System.out.println(service2.findRaceByStatus(1));
		
	}
	@Test
	public void test_firmUserDao() throws Exception {
		
		Firmuser firmuser = firmUserDao.findFirmUserById(1);
		System.out.println(firmuser);
	}
	@Test
	public void test_login() throws Exception {
		System.out.println(service.login("jiang", "jiang"));
	}
	
	@Test
	public void test_menu() throws Exception {
		System.out.println(menuService.showMenuInfo(1));
	}
	
	
	@Test
	public void test_role() throws Exception {
		System.out.println(roleService.showRole(1));
	}
	
	
	@Test
	public void test01() throws Exception {
		System.out.println(datasource.getConnection());
	}
	
	@Test
	public void test02() throws Exception {
		Manager manager = dao.findUserByName("jiang");
		System.out.println(manager);
	}
	
	
	@Autowired
	ExpertService exservice;
	
	@Test
	public void test_ex() throws Exception {
		Result result = exservice.selectExportByRoleId(2);
		System.out.println(result);
	}
	
	@Test
	public void test_data() throws Exception {
		System.out.println(new Date().toString().replaceAll(" ", "").replaceAll(":",""));
		//System.out.println();
	}
	

}
