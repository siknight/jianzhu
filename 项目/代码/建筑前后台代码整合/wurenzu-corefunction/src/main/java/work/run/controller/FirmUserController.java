package work.run.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.run.service.FirmUserService;
import work.run.util.Result;

@RestController
public class FirmUserController {
	@Autowired
	private FirmUserService service;
	
	//通过name查询参赛者
	@GetMapping("/firmuser/name")
	public Result findUserByName(String name) {
		return service.findUserByName(name);
	}
	
	//通过id查询参赛者
	@GetMapping("/firmuser/id")
	public Result findUserById(Integer id) {
		return service.findUserById(id);
	}
	
	//根据 期数 查询参赛者
	@GetMapping("/firmuser/period")
	public Result findAllByPeriod(Integer period) {
		return service.findAllByPeriod(period);
	}
		
	//查询最新一期的参赛者
	@GetMapping("/firmuser/newperiod")
	public Result findAllByMaxPeriod() {
		return service.findAllByMaxPeriod();
	}
		
	//根据name 模糊查询 某期的参赛者
	@GetMapping("/firmuser/nameLikeandperiod")
	public Result findByNameLike(@RequestParam("name") String name, @RequestParam("period") Integer period) {
		return service.findByNameLike(name, period);
	}
		
	//根据公司名 模糊查询 最新期的参赛者
	@GetMapping("/firmuser/firmName")
	public Result findByFirmMaxPeriod(String firmName) {
		return service.findByFirmMaxPeriod(firmName);
	}
		
	//根据公司名 模糊查询 某期的参赛者
	@GetMapping("/firmuser/firmNameandperiod")
	public Result findByFirmPeriod(@RequestParam("fileName") String firmName ,@RequestParam("period") Integer period) {
		return service.findByFirmPeriod(firmName,period);
	}
		
	//查询某期最高分的参赛者
	@GetMapping("/firmuser/periodmaxscore")
	public Result findByPeriodMaxScore(Integer period) {
		return service.findByPeriodMaxScore(period);
	}
	
		
	//查询前几期最高分的参赛者
	@GetMapping("/firmuser/somepermaxsco")
	public Result findBySomePeriodMaxScore(Integer period) {
		return service.findBySomePeriodMaxScore(period);
	}

	//查询每期最高分的参赛者
	@GetMapping("/firmuser/allperamxsco")
	public Result findbyAllPeriodMaxScore() {
		return service.findbyAllPeriodMaxScore();
	}

}
