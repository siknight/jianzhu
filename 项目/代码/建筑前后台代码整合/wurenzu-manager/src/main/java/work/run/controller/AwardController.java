package work.run.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.run.service.AwardService;

import work.run.util.Result;

@RestController
public class AwardController {
	@Autowired
AwardService service;
	
	/**
	 * 添加奖项
	 * @param aid
	 * @return
	 */

	//发布奖品
	@PutMapping("/award/updateaward")
	public Result updateAwardByAid(@RequestParam("workid") Integer workid,@RequestParam("aid") Integer aid) {
		
		return service.updateAwardByAid(workid, aid);
	}
	//查询奖品信息
	@GetMapping("/award/query")
	public Result findAwardByAid(@RequestParam("aid") int aid) {
		return service.findaward(aid);
	}
	
	
	/**
	 * 查询所有评委
	 * @return
	 */
	@GetMapping("/work/workid")
	public Result findWorkBygrade() {
		return service.findwork();
	}

}
