package work.run.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import work.run.service.CountService;
import work.run.util.Result;
@RestController
public class CountController {
	@Autowired
	CountService countservice;
	@GetMapping("/manager/count")
	public Result countfirmusercontroller() {
		return countservice.count();
	}
}
