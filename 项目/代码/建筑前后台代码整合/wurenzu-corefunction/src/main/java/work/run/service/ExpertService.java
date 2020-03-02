package work.run.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import work.run.dao.ExpertDao;

import work.run.pojo.Expert;
import work.run.util.Constant;
import work.run.util.Result;

@Service
public class ExpertService {
	@Autowired
	private ExpertDao expertdao;
	
//	@Autowired
//	RedisDao redisDao;
	//查询所有的专家,用户可以不登录也能查看专家团队
	public Result showAllExpert() {
	//redis读取
//	    Result result2=(Result)redisDao.getObject("selectallExport");
//	    if(!StringUtils.isEmpty(result2)) {
//		   return result2;
//				}
	    Result result = new Result();
		
		List<Expert> experts = expertdao.findAll();
		
		if(experts!=null) {//这里判空是因为专家团队肯定是有的
			result.setCode(Constant.OK); // 0
			result.setMsg("所有专家查询成功");
			result.setData(experts);
			//redisDao.saveObject("selectallExport", result);  //redis缓存
			return result;
		}
		else {
			result.setCode(Constant.error02); // 1
			result.setMsg("所有专家查询失败");
			return result;
			}
		}
	
	//根据id 查询单个专家详情
	public Result showAllExpertByid(Integer id) {
		Result result = new Result();
		
		Expert expert = expertdao.findById(id);
		if(expert!=null) {//这里判空是因为专家肯定是有的
			result.setCode(Constant.OK); // 0
			result.setMsg("根据id查询专家成功");
			result.setData(expert);
			return result;
		}
		else {
			result.setCode(Constant.error02); // 1
			result.setMsg("根据id查询专家失败");
			return result;
			}
	}
	
	//根据名称查询
	public Result showAllExpertByName(String name) {
		Result result = new Result();
		
		List<Expert> experts = expertdao.findByName(name);
		//这里不需要判空
		result.setCode(Constant.OK); // 0
		result.setMsg("根据name查询专家成功");
		result.setData(experts);
		return result;	
	}
	
	//根据名称模糊查询
	public Result showExpertByNameLike(String name) {
		Result result = new Result();
		
		List<Expert> experts = expertdao.findByName(name);
		//这里不需要判空
		result.setCode(Constant.OK); // 0
		result.setMsg("根据name模糊查询专家成功");
		result.setData(experts);
		return result;	
	}
	
	//根据id 模糊查询
	public Result showExpertByIdLike(Integer id) {
		Result result = new Result();
		
		List<Expert> experts = expertdao.findByIdLike(id);
		//这里不需要判空
		result.setCode(Constant.OK); // 0
		result.setMsg("根据id模糊查询专家成功");
		result.setData(experts);
		return result;	
	}

}
