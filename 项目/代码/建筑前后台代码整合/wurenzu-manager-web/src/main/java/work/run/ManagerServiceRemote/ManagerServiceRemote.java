package work.run.ManagerServiceRemote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



import work.run.util.Result;

@FeignClient(name="MANAGER-SERVICE")
public interface ManagerServiceRemote {
	/**
	 * 拦截验证
	 * @param userId
	 * @param token
	 * @return
	 */
	@PostMapping("/manager/author")
	public Result authorization(@RequestParam("userId") Integer userId,@RequestParam("token") String token);
	
	/**
	 * managerService 
	 * @param name
	 * @param password
	 * @return
	 */
	@PostMapping("/manager/login")
	public Result login(@RequestParam("name") String name,@RequestParam("password") String password) ;
	
	@PutMapping("/manager/myself")
	public Result updateById(@RequestParam("nick_name") String nick_name,@RequestParam("sex") String sex,@RequestParam("signature") String signature,@RequestParam("phone") String phone,@RequestParam("email") String email,@RequestParam("id") Integer id);
	
	
	@PutMapping("/manager/password")
	public Result updatePasswordById(@RequestParam("oldPassword") String oldPassword ,@RequestParam("password") String password, @RequestParam("id") Integer id);
}
