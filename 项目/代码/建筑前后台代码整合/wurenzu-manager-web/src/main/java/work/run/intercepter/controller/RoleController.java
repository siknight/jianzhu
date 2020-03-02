package work.run.intercepter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.run.ManagerServiceRemote.RoleServiceRemote;

import work.run.util.Result;

@RestController
public class RoleController {
	
	@Autowired
	RoleServiceRemote remote;
	@GetMapping("/manager/role")
	public Result showRole(@RequestParam("id") int id) {
		
		return remote.showRole(id);
	}

}
