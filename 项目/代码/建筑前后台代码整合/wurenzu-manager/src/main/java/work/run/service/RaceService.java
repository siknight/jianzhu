package work.run.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import work.run.dao.AwardDao;
import work.run.dao.RaceDao;
import work.run.pojo.Manager;
import work.run.pojo.Race;
import work.run.util.Constant;
import work.run.util.PasswordUtil;
import work.run.util.Result;

@Service
@Transactional
public class RaceService {
	
	@Autowired
	RaceDao raceDao;
	
	@Autowired
	AwardDao awardDao;

	
	/**
	 * 添加比赛
	 * @param raceName
	 * @param details
	 * @param period
	 * @return
	 */
	public Result addRace(String raceName,String details, Integer period,String imgUrl) {
		Result result = new Result();
		// 判断参数是否符合规则
		if (StringUtils.isEmpty(raceName) || StringUtils.isEmpty(details)| StringUtils.isEmpty(period)) {
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}
		 //默认添加后比赛就发布了  1表示状态
		
		  int i= raceDao.addRace(raceName, details, 1, period,imgUrl);
				  
		  if(i>0) {
			  //发布后奖品为空
			  awardDao.updateWorkIdForNull();

			   result.setCode(Constant.OK); // 2
			   result.setMsg(Constant.ADD_OK); // 添加成功
			   HashMap<String, String> imagemap = new HashMap<String, String>();
			   imagemap.put("img", imgUrl);
			   result.setData(imagemap);
		  }
		
		

		return result;

	}
	
	/**
	 * 删除比赛
	 * @param id
	 * @return
	 */
	public Result deleteRace(Integer status) {
		Result result = new Result();
		// 判断参数是否符合规则
		if (StringUtils.isEmpty(status)) {
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}

		
		  int i= raceDao.deleteRace(status);
				  
		  if(i>0) {

			   result.setCode(Constant.OK); // 2
			   result.setMsg(Constant.DELETE_OK); // 添加成功
		  }
		
		

		return result;

	}
	
	/**
	 * 查找全部比赛
	 * @return
	 */
	public Result findRace() {
		   Result result = new Result();
		
		
		   List<Race> list = raceDao.findRace();
		   if(StringUtils.isEmpty(list)) {
			   result.setCode(Constant.error01);
			   result.setMsg(Constant.QUERY_IS_FAIL);
			   return result;
		   }
		   
		   
		   result.setCode(Constant.OK);
		   result.setMsg(Constant.QUERY_IS_OK);
		   result.setData(list);
		  
		  return result;

	}
	
	/**
	 * 通过状态码查询比赛
	 */
	
	public Result findRaceByStatus(Integer status) {
		   Result result = new Result();
		
		   if(StringUtils.isEmpty(status)) {
			   result.setCode(Constant.error01);
			   result.setMsg(Constant.ARGS_IS_NULL);
			   return result;
		   }
		   
		   
		    Race race = raceDao.finRaceByStatus(status);
		    
		    if(StringUtils.isEmpty(race)) {
		    	result.setCode(Constant.error02);   //1
		    	result.setMsg(Constant.QUERY_IS_FAIL); 
		    	return result;
		    }
		  
		   
		   System.out.println("race_status="+race);
		   result.setCode(Constant.OK);
		   result.setMsg(Constant.QUERY_IS_OK);
		   result.setData(race);
		  return result;

	}
	
	
	/**
	 * 查找历史比赛
	 * @param status
	 * @return
	 */
	public Result findHistoryRaceByStatus(Integer status) {
		   Result result = new Result();
		
		   if(StringUtils.isEmpty(status)) {
			   result.setCode(Constant.error01);
			   result.setMsg(Constant.ARGS_IS_NULL);
			   return result;
		   }
		   
		   
		    List<Race> list = raceDao.finHistoryRaceByStatus(status);
		    
		    if(StringUtils.isEmpty(list)) {
		    	result.setCode(Constant.error02);   //1
		    	result.setMsg(Constant.QUERY_IS_FAIL); 
		    	return result;
		    }
		  
		   
		   System.out.println("race_status="+list);
		   result.setCode(Constant.OK);
		   result.setMsg(Constant.QUERY_IS_OK);
		   result.setData(list);
		  return result;

	}
	
	
	/**
	 * 通过id停止比赛
	 */
	
	public Result stopRaceById(Integer id) {
		   Result result = new Result();
		
		   if(StringUtils.isEmpty(id)) {
			   result.setCode(Constant.error01);
			   result.setMsg(Constant.ARGS_IS_NULL);
			   return result;
		   }
		   
		   
		    raceDao.stopRaceById( id);
		    
		  
		   result.setCode(Constant.OK);
		   result.setMsg(Constant.QUERY_IS_OK);
		   
		  return result;

	}
	
	

	/**
	 * 通过id停止比赛
	 */
	
	public Result updateRaceById(String raceName, String details, Integer period,Integer id) {
		   Result result = new Result();
		
		   if(StringUtils.isEmpty(raceName)||StringUtils.isEmpty(details)||StringUtils.isEmpty(period)||StringUtils.isEmpty(id)) {
			   result.setCode(Constant.error01);
			   result.setMsg(Constant.ARGS_IS_NULL);
			   return result;
		   }
		   
		   
		   raceDao.updateRaceById(raceName, details, period,1, id);
		   result.setCode(Constant.OK);
		   result.setMsg(Constant.QUERY_IS_OK);
		   
		  return result;

	}
}
