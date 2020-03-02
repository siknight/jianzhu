package com.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import work.run.CoreFunctionApplication;
import work.run.dao.RaceInfoDao;

@SpringBootTest(classes =CoreFunctionApplication.class)
@RunWith(SpringRunner.class)
public class TsetRaceInfoDao {
	@Autowired
	private RaceInfoDao dao;
	
	//查询最新发布的比赛信息 已测试成功6-22
	@Test
	public void test01() throws Exception {
		System.out.println(dao.findRaceInfoByMaxPeriod());
	}
	//根据 期数 查询发布的比赛信息 已测试成功6-22
	@Test
	public void test02() throws Exception {
		System.out.println(dao.findRaceInfoByPeriod(1));
	}
	//查询最新一期的数字 已测试成功6-22
	@Test
	public void test03() throws Exception {
		System.out.println(dao.findMaxPeriod());
	}

}
