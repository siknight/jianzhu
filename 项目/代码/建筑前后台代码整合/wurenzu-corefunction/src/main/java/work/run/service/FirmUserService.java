package work.run.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.run.dao.ExpertDao;
import work.run.dao.ExpertScoreDao;
import work.run.dao.FirmUserDao;
import work.run.dao.RaceInfoDao;
import work.run.dao.WorkDao;
import work.run.pojo.Expert;
import work.run.pojo.FirmUser;
import work.run.pojo.Work;
import work.run.util.Constant;
import work.run.util.Result;

@Service
public class FirmUserService {
	@Autowired
	private FirmUserDao userdao;
	
	//通过name查询参赛者
	public Result findUserByName(String name) {
		Result result = new Result();
		List<FirmUser> firms = userdao.findUserByName(name);
		result.setCode(Constant.OK); // 0
		result.setMsg("根据用户名查询参赛者成功");
		result.setData(firms);
		return result;
	}
	
	//通过id查询参赛者
	public Result findUserById(Integer id) {
		Result result = new Result();
		FirmUser firm = userdao.findUserById(id);
		result.setCode(Constant.OK); // 0
		result.setMsg("根据id查询参赛者成功");
		result.setData(firm);
		return result;
	}
	
	//根据 期数 查询参赛者
	public Result findAllByPeriod(Integer period) {
		Result result = new Result();
		List<FirmUser> firms = userdao.findAllByPeriod(period);
		result.setCode(Constant.OK); // 0
		result.setMsg("根据 期数 查询参赛者成功");
		result.setData(firms);
		return result;
	}
	
	//查询最新一期的参赛者
	public Result findAllByMaxPeriod() {
		Result result = new Result();
		List<FirmUser> firms = userdao.findAllByMaxPeriod();
		result.setCode(Constant.OK); // 0
		result.setMsg("查询最新一期参赛者成功");
		result.setData(firms);
		return result;
	}
	
	 //根据name 模糊查询 某期的参赛者
	public Result findByNameLike( String name,  Integer period) {
		Result result = new Result();
		List<FirmUser> firms = userdao.findByNameLike(name, period);
		result.setCode(Constant.OK); // 0
		result.setMsg("根据name 模糊查询 某期的参赛者成功");
		result.setData(firms);
		return result;
	}
	
	//根据name 模糊查询 最新期的参赛者
	public Result findByNameMaxPeriod(String name) {
		Result result = new Result();
		List<FirmUser> firms = userdao.findByNameMaxPeriod(name);
		result.setCode(Constant.OK); // 0
		result.setMsg("根据name 模糊查询 最新期的参赛者成功");
		result.setData(firms);
		return result;
	}
	
	
	//根据公司名 模糊查询 最新期的参赛者
	public Result findByFirmMaxPeriod(String firmName) {
		Result result = new Result();
		List<FirmUser> firms = userdao.findByFirmMaxPeriod(firmName);
		result.setCode(Constant.OK); // 0
		result.setMsg("根据公司名 模糊查询 最新期的参赛者成功");
		result.setData(firms);
		return result;
	}
	
	//根据公司名 模糊查询 某期的参赛者
	public Result findByFirmPeriod(String firmName ,Integer period) {
		Result result = new Result();
		List<FirmUser> firms = userdao.findByFirmPeriod(firmName ,period);
		result.setCode(Constant.OK); // 0
		result.setMsg("根据公司名 模糊查询 某期的参赛者成功");
		result.setData(firms);
		return result;
	}
	
	//查询某期最高分的参赛者
	public Result findByPeriodMaxScore(Integer period) {
		Result result = new Result();
		FirmUser firm  = userdao.findByPeriodMaxScore(period);
		result.setCode(Constant.OK); // 0
		result.setMsg("查询某期最高分的参赛者成功");
		result.setData(firm);
		return result;
	}
	
	//查询前几期最高分的参赛者
	public Result findBySomePeriodMaxScore(Integer period) {
		Result result = new Result();
		List<FirmUser> firms = userdao.findBySomePeriodMaxScore(period);
		result.setCode(Constant.OK); // 0
		result.setMsg("查询前几期最高分的参赛者成功");
		result.setData(firms);
		return result;
	}
	
	//查询每期最高分的参赛者
	public Result findbyAllPeriodMaxScore() {
		Result result = new Result();
		List<FirmUser> firms = userdao.findbyAllPeriodMaxScore();
		result.setCode(Constant.OK); // 0
		result.setMsg("查询前几期最高分的参赛者成功");
		result.setData(firms);
		return result;
	}
	
}
