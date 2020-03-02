package work.run.ServiceRemote;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import work.run.configuration.FeignMultipartSupportConfig;

import work.run.util.Constant;
import work.run.util.FileUtil;
import work.run.util.Result;

@FeignClient(name="COREFUNCTION-SERVICE",configuration=FeignMultipartSupportConfig.class)
public interface WorkServiceRemote {
	
	
	//提交作品  period 由前端传入比较好
	@PostMapping(value="/work/add",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result insert(@RequestParam("workname") String workname,@RequestPart("uploadFile") MultipartFile uploadFile,@RequestParam("firmUserid") Integer firmUserid,@RequestParam("details") String details,@RequestParam("period") Integer period);
	//根据 期数 查询所有参赛作品
	@GetMapping("work/allbyperiod")
	public Result findAllByPeriod(Integer period) ;
	
	//根据 期数 查询前几
	@GetMapping("work/winbyperiod")
	public Result  findWinByPeriod(@RequestParam("period") Integer period,@RequestParam("number") Integer number);
	//查询 每期 排名 前三的参赛作品也就是所有获奖作品
	@GetMapping("work/allwin")
	public Result  findAllWinByPeriodRank() ;
	
	//查询最新期的参赛作品
	@GetMapping("work/allmaxperiod")
	 public Result findAllByMaxPeriod() ;
	 
	//根据用户id查询参赛作品
	@GetMapping("work/allbyfirm")
	 public Result findAllByFirmUserId(Integer firmUserid) ;
	 
	//查询展品
	@GetMapping("work/exhibits")
	 public Result findAllExhibits();
	
	//查询所有参赛作品 根据 期数 分数排序
	@GetMapping("work/all")
	public Result findAll() ;
	
	//根据期数查询企业上传了几个作品
	@GetMapping("work/firmworkcoutbyperiod")
		public Result findcontByPeriodFirm(@RequestParam("firmUserid") Integer firmUserid);

}
