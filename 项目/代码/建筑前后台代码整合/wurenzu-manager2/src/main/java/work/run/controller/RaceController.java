package work.run.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import work.run.service.RaceService;
import work.run.util.FileUtil;
import work.run.util.Result;

@RestController
public class RaceController {
		
	@Autowired
	RaceService service;
	
	@PostMapping("/manager/race")
	public Result addRace(@RequestParam("raceName") String raceName,@RequestParam("details") String details,@RequestParam("period") Integer period,@RequestPart("uploadFile") MultipartFile uploadFile) {
		String tempFileName = FileUtil.FileUpload(uploadFile, "D:\\shixi\\images\\race", raceName);
		return service.addRace(raceName, details, period,"/race/"+tempFileName);
				
	}
	
	@DeleteMapping("/manager/race/{status}")
	public Result deleteRace(@PathVariable("status") Integer status) {
		System.out.println("删除参数"+status);
		
		return service.deleteRace(status);
				
	}
	
	@GetMapping("/manager/race")
	public Result findAllRace( ) {
		
		return service.findRace();
				
	}
	
	/**
	 * 1表示活动正在进行，0表示活动已经结束
	 * @param status
	 * @return
	 */
	
	@GetMapping("/manager/race/status")
	public Result findRaceByStatus(@RequestParam("status") Integer status) {
		System.out.println("通过状态查询比赛status="+status);
		
		return service.findRaceByStatus(status);
		
	}
	
	@PutMapping("/manager/race/id")
	public Result stopRaceById(@RequestParam("id") Integer id) {
		System.out.println("停止正在进行比赛");
		return service.stopRaceById(id);
		
	}
	
	
	@GetMapping("/manager/race/status/history")
	public Result findHistoryRaceByStatus(@RequestParam("status")  Integer status) {
		
		return service.findHistoryRaceByStatus(status);
	}
	
	@PutMapping("/manager/raceupdate/id")
	public Result updateById(@RequestParam("raceName") String raceName,@RequestParam("details") String details,@RequestParam("period") Integer period,@RequestParam("id") Integer id) {
		
		return service.updateRaceById(raceName, details, period, id);
	}
}
