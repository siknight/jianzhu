package work.run.ManagerServiceRemote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import work.run.util.Result;

@FeignClient(name="MANAGER-SERVICE")
public interface WorkServiceRemote {


	@GetMapping("/manager/works/status")
	public Result findAllWorkByStatus(@RequestParam("status") Integer status);
	
	@GetMapping("/manager/works/status/pageNum")
	public Result findAllWorkByStatusAndPage(@RequestParam(name="pageNum", defaultValue = "1")Integer pageNum,@RequestParam("status") Integer status);
	@GetMapping("/manager/works/status/pageNum/row")
	public Result findAllWorkByStatusAndPageAndRow(@RequestParam(name="pageNum",defaultValue = "1")Integer pageNum,@RequestParam("status") Integer status) ;
}
