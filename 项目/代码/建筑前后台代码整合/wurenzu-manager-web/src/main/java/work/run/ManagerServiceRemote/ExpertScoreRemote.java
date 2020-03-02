package work.run.ManagerServiceRemote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import work.run.util.Result;

@FeignClient(name="MANAGER-SERVICE")
public interface ExpertScoreRemote {
	
	@PutMapping("/manager/expert/score")
	public Result giveScore(@RequestParam("expertscore") Integer expertscore, @RequestParam("managerid")  Integer managerid,@RequestParam("workid") Integer workid);

}
