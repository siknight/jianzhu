package work.run.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.run.service.ExpertScoreService;
import work.run.util.Result;

@RestController
public class ExpertScoreController {

	@Autowired
	ExpertScoreService service;
	
	@PutMapping("/manager/expert/score")
	public Result giveScore(@RequestParam("expertscore") Integer expertscore, @RequestParam("managerid")  Integer managerid,@RequestParam("workid") Integer workid) {
		System.out.println("expertscore="+expertscore+",managerid="+managerid+",workid="+workid);
		return service.giveScore(expertscore, managerid, workid);
	}
}
