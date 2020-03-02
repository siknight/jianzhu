package work.run.ManagerServiceRemote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import work.run.util.Result;

@FeignClient(name="MANAGER-SERVICE")
public interface RoleServiceRemote {
	
	
	@GetMapping("/manager/role")
	public Result showRole(@RequestParam("id") int id);

}
