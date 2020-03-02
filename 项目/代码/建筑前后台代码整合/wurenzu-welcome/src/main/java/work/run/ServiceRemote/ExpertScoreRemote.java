package work.run.ServiceRemote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


import work.run.util.Result;

@FeignClient(name="COREFUNCTION-SERVICE")
public interface ExpertScoreRemote {

	//根据作品id 查询作品所有专家打分
	@GetMapping("score/workid")
	public Result  findAllByWorkId(Integer workid);
	
	//查询一个作品的最高分
	@GetMapping("score/maxbyworkid")
	public Result findOneMaxByWorkId(Integer workid); 
	
	//查询一个作品的最低分
	@GetMapping("score/minbyworkid")
	public Result findOneMinByWorkId(Integer workid);
	
	 //查询一个作品的平均分
	@GetMapping("score/avgbyworkid")
	public Result findOneAverageByWorkId(Integer workid); 

}
