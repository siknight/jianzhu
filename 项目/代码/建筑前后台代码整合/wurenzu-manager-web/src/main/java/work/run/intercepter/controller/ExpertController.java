package work.run.intercepter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import work.run.ManagerServiceRemote.ExpertServiceRemote;
import work.run.util.Result;

@RestController
public class ExpertController {
	
	@Autowired
	ExpertServiceRemote remote;
	
	
	@PostMapping("/manager/exportadd")
	public Result addExport(@RequestParam("name") String name,@RequestParam("sex") String sex,@RequestParam("password")  String password,@RequestPart("uploadFile") MultipartFile uploadFile,@RequestParam("details") String details,@RequestParam("phone") String phone,@RequestParam("email") String email) {
		return remote.addExport(name, sex, password, uploadFile, details, phone, email);
	}
	/**
	 * 修改评委
	 * @param name
	 * @param sex
	 * @param password
	 * @param details
	 * @param id
	 * @return
	 */
	
	
	@PutMapping("/manager/exportupdate")
	public Result updateExportByid(@RequestParam("name") String name,@RequestParam("sex") String sex, @RequestParam("password") String password,@RequestParam("details")  String details,@RequestParam("phone") String phone,@RequestParam("email") String email,@RequestParam("id") int id) {
		
		return remote.updateExportByid(name, sex, password, details, phone, email, id);
	}
	
	
	/**
	 * 查询所有评委
	 * @return
	 */
	
	@GetMapping("/manager/roleid")
	public Result findExportByRoleId() {
		return remote.findExportByRoleId();
		
	}
	
	@DeleteMapping("/manager/exportdelete/{name}")
	public Result DeleteExportByName(@PathVariable("name")  String name) {
		return remote.DeleteExportByName(name);
	}
	
	

}
