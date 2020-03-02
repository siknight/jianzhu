package work.run.controller;

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

import work.run.service.ExpertService;
import work.run.util.FileUtil;
import work.run.util.Result;
/**
 * 评委专家controller类
 * @author Think
 *
 */

@RestController
public class ExpertController {

	@Autowired
	ExpertService service;
	
	/**
	 * 添加评委
	 * @param name
	 * @param sex
	 * @param password
	 * @param details
	 * @return
	 */
	@PostMapping("/manager/exportadd")
	public Result addExport(@RequestParam("name") String name,@RequestParam("sex") String sex,@RequestParam("password")  String password,@RequestPart("uploadFile") MultipartFile uploadFile,@RequestParam("details") String details,@RequestParam("phone") String phone,@RequestParam("email") String email) {
		//上传的文件存放在一个绝对路径里
		String tempFileName = FileUtil.FileUpload(uploadFile,"D:\\shixi\\images\\expert",name);
		//数据库存的相对路径和物理路径进行映射
		return service.addExport(name, sex, password,"/expert/"+tempFileName, details,phone,email);
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
		
		return service.updateExportById(name, sex, password, details,phone,email, id);
	}
	
	
	/**
	 * 查询所有评委
	 * @return
	 */
	
	@GetMapping("/manager/roleid")
	public Result findExportByRoleId() {
		return service.selectExportByRoleId(2);
	}
	
	@DeleteMapping("/manager/exportdelete/{name}")
	public Result DeleteExportByName(@PathVariable("name")  String name) {
		return service.deleteExportByName(name);
	}
	
	
}
