package work.run.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import work.run.service.ManagerService;
import work.run.util.Result;

@RestController
public class ManagerController {
	
	@Autowired
	ManagerService service;
	
	@PostMapping("/manager/login")
	public Result login(@RequestParam("name") String name,@RequestParam("password") String password) {
		
		return  service.login(name, password);
	}
	
	@PutMapping("/manager/myself")
	public Result updateById(@RequestParam("nick_name") String nick_name,@RequestParam("sex") String sex,@RequestParam("signature") String signature,@RequestParam("phone") String phone,@RequestParam("email") String email,@RequestParam("id") Integer id) {
		return service.updateById(nick_name, sex, signature,phone,email, id);
	}
	
	@PutMapping("/manager/password")
	public Result updatePasswordById(@RequestParam("oldPassword") String oldPassword ,@RequestParam("password") String password, @RequestParam("id") Integer id) {
		System.out.println("oldPassword="+oldPassword+",password="+password+",id="+id);
		return service.updatePasswordById(oldPassword,password, id);
	}
	
	@PostMapping("/manager/author")
	public Result authorization(@RequestParam("userId") Integer userId,@RequestParam("token") String token){
		Result result = service.checkToken(userId, token);
		return result;
	}
	

}
