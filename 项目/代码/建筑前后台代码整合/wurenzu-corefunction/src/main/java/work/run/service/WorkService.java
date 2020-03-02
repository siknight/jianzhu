package work.run.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.run.dao.FirmUserDao;
import work.run.dao.RaceInfoDao;
import work.run.dao.WorkDao;
import work.run.pojo.FirmUser;
import work.run.pojo.Work;
import work.run.util.Constant;
import work.run.util.Result;

@Service
public class WorkService {
	@Autowired
	private WorkDao dao;
	@Autowired
	private FirmUserDao userdao;
	@Autowired
	private RaceInfoDao racedao;
	
	//提交作品  period 由前端传入比较好
	public Result insert(String workname,String imgUrl,Integer firmUserid,String details,Integer period) {
		Result result = new Result();
		int flag = dao.insert(workname,imgUrl,firmUserid,details,period);
		if(flag==1) {
			result.setCode(Constant.OK); // 0
			result.setMsg("提交作品成功");
			return result;
			
		}else {
			result.setCode(Constant.error01); // 0
			result.setMsg("提交作品失败");
			return result;
		}
	}
	
	//根据 期数 查询所有参赛作品
	public Result findAllByPeriod(Integer period) {
		Result result = new Result();
		List<Work> works  = dao.findAllByPeriod(period);
		result.setCode(Constant.OK); // 0
		result.setData(works);
		result.setMsg("根据 期数 查询所有参赛作品成功");
		return result;
	}
	
	//根据 期数 查询前几
	public Result  findWinByPeriod(Integer period, Integer number) {
		Result result = new Result();
		List<Work> works  = dao. findWinByPeriod(period, number);
		result.setCode(Constant.OK); // 0
		result.setData(works);
		result.setMsg("根据 期数 查询前几成功");
		return result;
	}
	
	//查询 每期 排名 前三的参赛作品 
	//这里最好不要使用hashmap 里边内置的排序算法会让之前works的排序混乱
	public Result  findAllWinByPeriodRank() {
		Result result = new Result();
		//List<Work> works = dao.findAllWinByPeriodRank(); 不能这样写，前台不好处理
		List<List<Work>> winworks = new ArrayList<List<Work>>();
		int maxperiod = racedao.findMaxPeriod();
		//本期只有发布了奖品才能查本期的奖品
		for(int i=maxperiod;i>maxperiod-3;i--) {
//			if(i==maxperiod) {
//				List<Work> oneTerm2 = null;
//				oneTerm2 = dao.findWinByPeriod(i,3);//查询的是每一期的前三名
//				if(oneTerm2==null) {
//					//最新期没有发布奖品
//					break;//跳出本次循环
//				}else {
//					
//				}
//			}
			if(i>0) {
				List<Work> oneTerm = dao.findWinByPeriod(i,3);//查询的是每一期的前三名
				winworks.add(oneTerm);
			}
			
		}
		result.setCode(Constant.OK); // 0
		result.setMsg("查询 每期 排名 前三的参赛作品成功");
		result.setData(winworks);
		return result;
	}
	
	//查询最新期的参赛作品  作品名 参赛企业 项目详情 一个企业只能上传一个作品
	public Result findAllByMaxPeriod() {
		Result result = new Result();
		//List<Work> works  = dao.findAllByMaxPeriod();
		//Map<FirmUser,List<Work>> works = new HashMap<FirmUser,List<Work> >();
		Map<String,Work> alls = new HashMap<String,Work>();
		List<Work> works = dao.findAllByMaxPeriod();
		//有一个问题，万一后期改成一个用户提交多个作品，这种写法就行不通
		//解决方案 公司名+workid 设置为key值，前端用angular 的过滤器把workid过滤掉
		for(Work work: works) {
			FirmUser user = userdao.findUserById(work.getFirmUserid());
			alls.put(user.getFirmName()+work.getWorkid(), work);
		}
		result.setCode(Constant.OK); // 0
		result.setMsg("今年所有参赛作品和企业信息查询成功");
		result.setData(alls);
		return result;
		
	}
	
	//查询所有参赛作品 根据 期数 分数排序
		public Result findAll() {
			Result result = new Result();
			Map<String,Work> alls = new HashMap<String,Work>();
            //有个问题 key值相同的时候 value会被替换掉 这样 user 里边改成公司名+期数
			//如果一个公司一期可以提交多个作品的话，这样也行不通
			//解决方案 公司名+workid 设置为key值 前端用angular 的过滤器把workid过滤掉
			List<Work> works = dao.findAll();
			for(Work work: works) {
				FirmUser user = userdao.findUserById(work.getFirmUserid());
				alls.put(user.getFirmName()+work.getWorkid(), work);
			}
			
			result.setCode(Constant.OK); // 0
			result.setData(alls);
			result.setMsg("查询展品成功");
			return result;
		}
	
	
	//根据用户id查询参赛作品
	public Result findAllByFirmUserId(Integer firmUserid) {
		Result result = new Result();
		Work works  = dao.findAllByFirmUserId(firmUserid);
		result.setCode(Constant.OK); // 0
		result.setData(works);
		result.setMsg("根据用户id查询参赛作品成功");
		return result;
	}
	
	//查询展品
	public Result findAllExhibits() {
		Result result = new Result();
		List<Work> works  = dao.findAllExhibits();
		result.setCode(Constant.OK); // 0
		result.setData(works);
		result.setMsg("查询展品成功");
		return result;
	}
	
	//根据期数查询企业上传了几个作品
	public Result findcontByPeriodFirm(Integer firmUserid) {
		Result result = new Result();
		int newPeriod = racedao.findMaxPeriod();
		int status  = racedao.findMaxStatus(newPeriod);
		int count = dao.findcontByPeriodFirm(newPeriod,firmUserid);
		//提交作品之前查询 比赛信息状态码
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		result.setCode(Constant.OK); // 0
		data.put("count", count);
		data.put("newPeriod",newPeriod );
		data.put("status ", status);
		result.setData(data);
		
		result.setMsg("根据期数查询企业上传了几个作品成功");
		return result;
	}
	

}
