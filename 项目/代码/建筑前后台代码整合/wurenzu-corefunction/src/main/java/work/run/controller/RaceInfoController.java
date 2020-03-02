package work.run.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import work.run.service.RaceInfoService;
import work.run.util.Result;

@RestController
public class RaceInfoController {
	@Autowired
	private RaceInfoService service;
	
	//查询最新发布的比赛信息
	@GetMapping("/raceinfo/maxperiod")
	public Result findRaceInfoByMaxPeriod() {
		return service.findRaceInfoByMaxPeriod();
	}
	
	//根据 期数 查询发布的比赛信息
	@GetMapping("/raceinfo/period")
	public Result  findRaceInfoByPeriod(Integer id) {
		return service.findRaceInfoByPeriod(id);
	}
	//查询最新一期的数字
	@GetMapping("/raceinfo/periodvalue")
	public Result findMaxPeriod() {
		return service.findMaxPeriod();
	}

}
