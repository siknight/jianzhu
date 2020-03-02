package work.run.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import work.run.dao.RaceInfoDao;

import work.run.pojo.RaceInfo;
import work.run.util.Constant;
import work.run.util.Result;

@Service
public class RaceInfoService {
	@Autowired
	private RaceInfoDao dao;
	
//	@Autowired
//	RedisDao redisDao;
	//查询最新发布的比赛信息
	public Result findRaceInfoByMaxPeriod() {
		Result result = new Result();
		List<RaceInfo> infos = dao.findRaceInfoByMaxPeriod();
		result.setCode(Constant.OK); // 0
		result.setMsg("查询最新发布的比赛信息成功");
		result.setData(infos);
		
		return result;
	}
	
	//根据 期数 查询发布的比赛信息
	public Result  findRaceInfoByPeriod(int id) {
		Result result = new Result();
		List<RaceInfo> infos = dao.findRaceInfoByPeriod(id);
		result.setCode(Constant.OK); // 0
		result.setMsg("根据 期数 查询发布的比赛信息成功");
		result.setData(infos);
		return result;
	}
	
	//查询最新一期的数字
	public Result findMaxPeriod() {
		Result result = new Result();
		int newPeriod = dao.findMaxPeriod();
		result.setCode(Constant.OK); // 0
		result.setMsg("查询最新一期的数字成功");
		
		result.setData(newPeriod);
		return result;
	}
	

}
