package work.run.intercepter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.run.ManagerServiceRemote.ExpertScoreRemote;
import work.run.util.Result;

@RestController
public class ExpertScoreController {
	
	@Autowired
	ExpertScoreRemote remote;
	
	@PutMapping("/manager/expert/score")
	public Result giveScore(@RequestParam("expertscore") Integer expertscore, @RequestParam("managerid")  Integer managerid,@RequestParam("workid") Integer workid) {
		return remote.giveScore(expertscore, managerid, workid);
	}
}
