package work.run.ManagerServiceRemote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import work.run.util.Result;

@FeignClient(name="MANAGER-SERVICE")
public interface AwardServiceRemote {
	
	
	/**
	 * 添加奖项
	 * @param aid
	 * @return
	 */

	//发布奖品
	@PutMapping("/award/updateaward")
	public Result updateAwardByAid(@RequestParam("workid") Integer workid,@RequestParam("aid") Integer aid);
	//查询奖品信息
	@GetMapping("/award/query")
	public Result findAwardByAid(@RequestParam("aid") int aid) ;
	
	/**
	 * 查询所有评委
	 * @return
	 */
	@GetMapping("/work/workid")
	public Result findWorkBygrade() ;

}
