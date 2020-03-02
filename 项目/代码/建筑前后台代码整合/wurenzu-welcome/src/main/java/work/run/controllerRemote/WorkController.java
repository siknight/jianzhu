package work.run.controllerRemote;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import work.run.ServiceRemote.WorkServiceRemote;
import work.run.util.Constant;
import work.run.util.FileUtil;
import work.run.util.Result;

@RestController
public class WorkController {
	@Autowired
	private WorkServiceRemote remote;
	
	//提交作品  period 由前端传入比较好
	@PostMapping("/work/add")
	public Result insert(@RequestParam("workname") String workname,@RequestPart("uploadFile") MultipartFile uploadFile,@RequestParam("firmUserid") Integer firmUserid,@RequestParam("details") String details,@RequestParam("period") Integer period){
		
		return remote.insert(workname, uploadFile, firmUserid, details, period);
		
	}
	
	//根据 期数 查询所有参赛作品
	@GetMapping("work/allbyperiod")
	public Result findAllByPeriod(Integer period) {
		return remote.findAllByPeriod(period);
	}
	
	//根据 期数 查询前几
	@GetMapping("work/winbyperiod")
	public Result  findWinByPeriod(@RequestParam("period") Integer period,@RequestParam("number") Integer number) {
		return remote.findWinByPeriod(period, number);
	}
	
	//查询 每期 排名 前三的参赛作品也就是所有获奖作品
	@GetMapping("work/allwin")
	public Result  findAllWinByPeriodRank() {
		return remote.findAllWinByPeriodRank();
	}
	
	//查询最新期的参赛作品
	@GetMapping("work/allmaxperiod")
	 public Result findAllByMaxPeriod() {
		 return remote.findAllByMaxPeriod();
	 }
	 
	//根据用户id查询参赛作品
	@GetMapping("work/allbyfirm")
	 public Result findAllByFirmUserId(Integer firmUserid) {
		 return remote.findAllByFirmUserId(firmUserid);
	 }
	 
	//查询展品
	@GetMapping("work/exhibits")
	 public Result findAllExhibits() {
		 return remote.findAllExhibits();
	 }
	
	//查询所有参赛作品 根据 期数 分数排序
	@GetMapping("work/all")
	public Result findAll() {
			return remote.findAll();
	}
	
	//根据期数查询企业上传了几个作品
	@GetMapping("work/firmworkcoutbyperiod")
		public Result findcontByPeriodFirm(@RequestParam("firmUserid") Integer firmUserid) {
			System.out.println("firmUserid="+firmUserid);
			return remote.findcontByPeriodFirm(firmUserid);
		}

}
