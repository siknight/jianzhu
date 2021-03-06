package work.run.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import work.run.service.ExpertScoreService;
import work.run.util.Result;

@RestController
public class ExpertScoreController {
	@Autowired
	private ExpertScoreService service;
	
	//根据作品id 查询作品所有专家打分
	@GetMapping("score/workid")
	public Result  findAllByWorkId(Integer workid) {
		return service.findAllByWorkId(workid);
	}
	
	//查询一个作品的最高分
	@GetMapping("score/maxbyworkid")
	public Result findOneMaxByWorkId(Integer workid) {
		return service.findOneMaxByWorkId(workid);
	}
	
	//查询一个作品的最低分
	@GetMapping("score/minbyworkid")
	public Result findOneMinByWorkId(Integer workid) {
		return service.findOneMinByWorkId(workid);
	}
	
	 //查询一个作品的平均分
	@GetMapping("score/avgbyworkid")
	public Result findOneAverageByWorkId(Integer workid) {
		return service.findOneAverageByWorkId(workid);
	}

}
