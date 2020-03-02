package work.run.ServiceRemote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import work.run.configuration.FeignMultipartSupportConfig;
import work.run.util.Result;

@FeignClient(name="COREFUNCTION-SERVICE")
public interface ExpertServiceRemote {
	
	//查询所有的专家
	@GetMapping("/expert/findAll")
	public Result showAllExpert() ;
	
	//根据id 查询单个专家详情
	@GetMapping("/expert/find/{id}")
	public Result showAllExpertByid(@PathVariable("id") Integer id);
		
	//根据名称查询
	@GetMapping("/expert/find/{name}")
	public Result showAllExpertByName(@PathVariable("id") String name) ;
		
	//根据名称模糊查询
	@GetMapping("/expert/find/{namelike}")
	public Result showExpertByNameLike(@PathVariable("namelike") String name);
		
	//根据id 模糊查询
	@GetMapping("/expert/find/{idlike}")
	public Result showExpertByIdLike(@PathVariable("idlike") Integer id) ;

}
