package work.run.ManagerServiceRemote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import work.run.configuration.FeignMultipartSupportConfig;
import work.run.util.Result;

@FeignClient(name="MANAGER-SERVICE",configuration=FeignMultipartSupportConfig.class)
public interface RaceServiceRemote {
		

	@PostMapping(value="/manager/race",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result addRace(@RequestParam("raceName") String raceName,@RequestParam("details") String details,@RequestParam("period") Integer period,@RequestPart("uploadFile") MultipartFile uploadFile);
	
	@DeleteMapping("/manager/race/{status}")
	public Result deleteRace(@PathVariable("status") Integer status) ;
	
	@GetMapping("/manager/race")
	public Result findAllRace( ) ;
	
	/**
	 * 1表示活动正在进行，0表示活动已经结束
	 * @param status
	 * @return
	 */
	
	@GetMapping("/manager/race/status")
	public Result findRaceByStatus(@RequestParam("status") Integer status);
	
	@PutMapping("/manager/race/id")
	public Result stopRaceById(@RequestParam("id") Integer id) ;
	
	
	@GetMapping("/manager/race/status/history")
	public Result findHistoryRaceByStatus(@RequestParam("status") Integer status) ;
	
	@PutMapping("/manager/raceupdate/id")
	public Result updateById(@RequestParam("raceName") String raceName,@RequestParam("details") String details,@RequestParam("period") Integer period,@RequestParam("id") Integer id) ;
}
