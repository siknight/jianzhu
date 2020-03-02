package work.run.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.run.service.RoleService;
import work.run.util.Result;

@RestController
public class RoleController {
	
	@Autowired
	RoleService service;
	@GetMapping("/manager/role")
	public Result showRole(@RequestParam("id") int id) {
		
		return service.showRole(id);
	}

}
