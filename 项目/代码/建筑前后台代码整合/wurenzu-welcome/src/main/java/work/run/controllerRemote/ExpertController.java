package work.run.controllerRemote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import work.run.ServiceRemote.ExpertServiceRemote;

import work.run.util.Result;

@RestController
public class ExpertController {
	@Autowired
	private ExpertServiceRemote remote;
	
	//查询所有的专家
	@GetMapping("/expert/findAll")
	public Result showAllExpert() {
		return remote.showAllExpert();
	}
	
	//根据id 查询单个专家详情
	@GetMapping("/expert/find/{id}")
	public Result showAllExpertByid(@PathVariable("id") Integer id) {
		return remote.showAllExpertByid(id);
	}
		
	//根据名称查询
	@GetMapping("/expert/find/{name}")
	public Result showAllExpertByName(@PathVariable("id") String name) {
		return remote.showAllExpertByName(name);
	}
		
	//根据名称模糊查询
	@GetMapping("/expert/find/{namelike}")
	public Result showExpertByNameLike(@PathVariable("namelike") String name) {
		return remote.showExpertByNameLike(name);
	}
		
	//根据id 模糊查询
	@GetMapping("/expert/find/{idlike}")
	public Result showExpertByIdLike(@PathVariable("idlike") Integer id) {
		return remote.showExpertByIdLike(id);
	}

}
