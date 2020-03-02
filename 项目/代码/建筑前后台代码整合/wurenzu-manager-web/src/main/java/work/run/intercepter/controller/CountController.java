package work.run.intercepter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import work.run.ManagerServiceRemote.CountServiceRemote;
import work.run.util.Result;

@RestController
public class CountController {
	
	@Autowired
	CountServiceRemote remote;

	@GetMapping("/manager/count")
	public Result countfirmusercontroller() {
		return remote.countfirmusercontroller();
	}
}
