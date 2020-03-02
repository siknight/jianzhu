package work.run.intercepter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.run.ManagerServiceRemote.MenuServiceRemote;

import work.run.util.Result;

@RestController
public class MenuController {
	@Autowired
	MenuServiceRemote remote;
	
	@GetMapping("/manager/menu")
	public Result showMenu(@RequestParam("id") int id) {
		
		return remote.showMenu(id);
		
	}

}
