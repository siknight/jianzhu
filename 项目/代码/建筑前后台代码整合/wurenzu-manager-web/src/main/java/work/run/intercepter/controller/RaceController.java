package work.run.intercepter.controller;

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

import work.run.ManagerServiceRemote.RaceServiceRemote;

import work.run.util.Result;

@RestController
public class RaceController {
		
	@Autowired
	RaceServiceRemote remote;
	
	@PostMapping("/manager/race")
	public Result addRace(@RequestParam("raceName") String raceName,@RequestParam("details") String details,@RequestParam("period") Integer period,@RequestPart("uploadFile") MultipartFile uploadFile) {
		return remote.addRace(raceName, details, period, uploadFile);
				
				
	}
	
	@DeleteMapping("/manager/race/{status}")
	public Result deleteRace(@PathVariable("status") Integer status) {
		return remote.deleteRace(status);
				
	}
	
	@GetMapping("/manager/race")
	public Result findAllRace( ) {
		
		return remote.findAllRace();
				
	}
	
	/**
	 * 1表示活动正在进行，0表示活动已经结束
	 * @param status
	 * @return
	 */
	
	@GetMapping("/manager/race/status")
	public Result findRaceByStatus(@RequestParam("status") Integer status) {
		return remote.findRaceByStatus(status);
		
	}
	
	@PutMapping("/manager/race/id")
	public Result stopRaceById(@RequestParam("id") Integer id) {
		return remote.stopRaceById(id);
		
	}
	
	
	@GetMapping("/manager/race/status/history")
	public Result findHistoryRaceByStatus(@RequestParam("status")  Integer status) {
		
		return remote.findHistoryRaceByStatus(status);
	}
	
	@PutMapping("/manager/raceupdate/id")
	public Result updateById(@RequestParam("raceName") String raceName,@RequestParam("details") String details,@RequestParam("period") Integer period,@RequestParam("id") Integer id) {
		
		return remote.updateById(raceName, details, period, id);
	}
}
