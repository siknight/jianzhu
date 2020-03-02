package work.run.ManagerServiceRemote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import work.run.util.Result;

@FeignClient(name="MANAGER-SERVICE")
public interface CountServiceRemote {

	@GetMapping("/manager/count")
	public Result countfirmusercontroller() ;
}
