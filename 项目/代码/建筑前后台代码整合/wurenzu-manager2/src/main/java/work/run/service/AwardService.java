package work.run.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import work.run.dao.AwardDao;
import work.run.dao.FirmUserdao;
import work.run.dao.WorkDao;
import work.run.pojo.Award;
import work.run.pojo.Firmuser;
import work.run.pojo.Manager;
import work.run.pojo.Race;
import work.run.pojo.Work;
import work.run.util.Constant;
import work.run.util.PasswordUtil;
import work.run.util.Result;

@Service
public class AwardService {

	@Autowired
	AwardDao awardDao;

	@Autowired
	FirmUserdao firmUserDao;
	
	@Autowired
	WorkDao workdao;
	
	/**
	 * 添加比赛
	 * @param aname
	 * @param price
	 * @return
	 */
//发布奖品
	public Result updateAwardByAid(Integer workid,Integer aid) {
		Result result = new Result();
		// 判断参数是否符合规则
		if (StringUtils.isEmpty(aid) ){
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}
		int i = awardDao.updateWorkById(workid, aid);
		if(i>0) {
			result.setCode(Constant.OK);
			result.setMsg(Constant.UPDATE_OK);
			workdao.updateStatus(0, workid);
		}
		return result;
	}
	
	
	
//查询奖品信息
	public Result findaward(int aid){
		Result result=new Result();
		if(StringUtils.isEmpty(aid)){
			   result.setCode(Constant.error01);
			   result.setMsg(Constant.QUERY_IS_FAIL);
			   return result;
		}
		List<Award> list = awardDao.selectAwardByaid(aid);
		result.setCode(Constant.OK);
		result.setMsg(Constant.QUERY_IS_OK);
		result.setData(list);
		return result;
	}

	/**
	 * 查询获奖作品
	 * @return
	 */
	public Result findwork(){
		Result result=new Result();
		List<Work>list=awardDao.selectWorkBygrade();
		if(StringUtils.isEmpty(list)){
			   result.setCode(Constant.error01);
			   result.setMsg(Constant.QUERY_IS_FAIL);
			   return result;
		}
		   for(int i=0;i<list.size();i++) {
			    int firmUserid = list.get(i).getFirmUserid(); 
			    Firmuser firmuser = firmUserDao.findFirmUserById(firmUserid); 
			    list.get(i).setFirmuser(firmuser);    
			    int workid = list.get(i).getWorkid();
			    Award award2 = awardDao.selectByworkId(workid);
			    list.get(i).setAward(award2);
		   }
		   result.setCode(Constant.OK);
		   result.setMsg(Constant.QUERY_IS_OK);
		   result.setData(list);
		  return result;
	}


}
