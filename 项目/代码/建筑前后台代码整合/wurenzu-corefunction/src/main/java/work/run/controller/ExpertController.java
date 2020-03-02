package work.run.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import work.run.service.ExpertService;
import work.run.util.Result;

@RestController
public class ExpertController {
	@Autowired
	private ExpertService service;
	
	//查询所有的专家
	@GetMapping("/expert/findAll")
	public Result showAllExpert() {
		return service.showAllExpert();
	}
	
	//根据id 查询单个专家详情
	@GetMapping("/expert/find/{id}")
	public Result showAllExpertByid(@PathVariable("id") Integer id) {
		return service.showAllExpertByid(id);
	}
		
	//根据名称查询
	@GetMapping("/expert/find/{name}")
	public Result showAllExpertByName(@PathVariable("id") String name) {
		return service.showAllExpertByName(name);
	}
		
	//根据名称模糊查询
	@GetMapping("/expert/find/{namelike}")
	public Result showExpertByNameLike(@PathVariable("namelike") String name) {
		return service.showExpertByNameLike(name);
	}
		
	//根据id 模糊查询
	@GetMapping("/expert/find/{idlike}")
	public Result showExpertByIdLike(@PathVariable("idlike") Integer id) {
		return service.showExpertByIdLike(id);
	}

}
