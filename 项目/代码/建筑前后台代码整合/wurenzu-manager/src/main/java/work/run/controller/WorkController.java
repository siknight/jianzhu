package work.run.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import work.run.service.WorkService;
import work.run.util.Result;

@RestController
public class WorkController {

	@Autowired
	WorkService workservice;
	@GetMapping("/manager/works/status")
	public Result findAllWorkByStatus(@RequestParam("status") Integer status) {
		
		return workservice.findAllWorkByStatus(status); 
	}
	
	@GetMapping("/manager/works/status/pageNum")
	public Result findAllWorkByStatusAndPage(@RequestParam(name="pageNum",defaultValue = "1")Integer pageNum,@RequestParam("status") Integer status) {
		return workservice.findAllWorkByStatusAndPage(pageNum, status);
	}
	@GetMapping("/manager/works/status/pageNum/row")
	public Result findAllWorkByStatusAndPageAndRow(@RequestParam(name="pageNum",defaultValue = "1")Integer pageNum,@RequestParam("status") Integer status) {
		return workservice.findAllWorkByStatusAndPageAndRow(pageNum, status);
	}
}
