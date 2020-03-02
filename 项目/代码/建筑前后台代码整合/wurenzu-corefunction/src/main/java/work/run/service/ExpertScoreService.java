package work.run.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.run.dao.ExpertScoreDao;
import work.run.pojo.ExpertScore;
import work.run.util.Constant;
import work.run.util.Result;

@Service
public class ExpertScoreService {
	@Autowired
	private ExpertScoreDao dao;
	
	//根据作品id 查询作品所有专家打分
	public Result  findAllByWorkId(Integer workid) {
		Result result = new Result();
		List<ExpertScore> scores = dao.findAllByWorkId(workid);
		result.setCode(Constant.OK); // 0
		result.setMsg("根据作品id 查询作品所有专家打分成功");
		result.setData(scores);
		return result;
	}
	
	//查询一个作品的最高分
	public Result findOneMaxByWorkId(Integer workid) {
		Result result = new Result();
		List<ExpertScore> scores = dao.findOneMaxByWorkId(workid);
		result.setCode(Constant.OK); // 0
		result.setMsg("查询一个作品的最高分成功");
		result.setData(scores);
		return result;
	}
	
	//查询一个作品的最低分
	public Result findOneMinByWorkId(Integer workid) {
		Result result = new Result();
		List<ExpertScore> scores = dao.findOneMinByWorkId(workid);
		result.setCode(Constant.OK); // 0
		result.setMsg("查询一个作品的最低分成功");
		result.setData(scores);
		return result;
	}
	
	 //查询一个作品的平均分
	public Result findOneAverageByWorkId(Integer workid) {
		Result result = new Result();
		List<ExpertScore> scores = dao.findOneAverageByWorkId(workid);
		result.setCode(Constant.OK); // 0
		result.setMsg("查询一个作品的平均分成功");
		result.setData(scores);
		return result;
	}

}
