package work.run.intercepter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.run.ManagerServiceRemote.ManagerServiceRemote;
import work.run.util.Constant;
import work.run.util.Result;

@RestController
public class ManagerController {
	
	@Autowired
	private ManagerServiceRemote remote;
	
	@PostMapping("/manager/login")
	public Result login(String name,String password) {
		System.out.println("本地正在验证");
		return remote.login(name, password);
	}

	@GetMapping("/manager/verify")
	public Result touser_center() {
		Result result = new Result();
		result.setCode(Constant.OK);
		result.setMsg("验证成功");
		return result;
	}
	
	
	@PutMapping("/manager/myself")
	public Result updateById(@RequestParam("nick_name") String nick_name,@RequestParam("sex") String sex,@RequestParam("signature") String signature,@RequestParam("phone") String phone,@RequestParam("email") String email,@RequestParam("id") Integer id) {
		return remote.updateById(nick_name, sex, signature, phone, email, id);
	}
	
	
	@PutMapping("/manager/password")
	public Result updatePasswordById(@RequestParam("oldPassword") String oldPassword ,@RequestParam("password") String password, @RequestParam("id") Integer id) {
		return remote.updatePasswordById(oldPassword, password, id);
	}

}
