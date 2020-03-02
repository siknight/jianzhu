package work.run.ServiceRemote;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import work.run.util.Result;

@FeignClient(name="COREFUNCTION-SERVICE")
public interface RaceInfoRemote {
	
	
	//查询最新发布的比赛信息
	@GetMapping("/raceinfo/maxperiod")
	public Result findRaceInfoByMaxPeriod();
	//根据 期数 查询发布的比赛信息
	@GetMapping("/raceinfo/period")
	public Result  findRaceInfoByPeriod(Integer id);
	//查询最新一期的数字
	@GetMapping("/raceinfo/periodvalue")
	public Result findMaxPeriod() ;

}
