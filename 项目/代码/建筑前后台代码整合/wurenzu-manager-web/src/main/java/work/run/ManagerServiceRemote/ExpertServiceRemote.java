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
public interface ExpertServiceRemote {

	
	@PostMapping(value="/manager/exportadd",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result addExport(@RequestParam("name") String name,@RequestParam("sex") String sex,@RequestParam("password")  String password,@RequestPart("uploadFile") MultipartFile uploadFile,@RequestParam("details") String details,@RequestParam("phone") String phone,@RequestParam("email") String email) ;
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
	public Result updateExportByid(@RequestParam("name") String name,@RequestParam("sex") String sex, @RequestParam("password") String password,@RequestParam("details")  String details,@RequestParam("phone") String phone,@RequestParam("email") String email,@RequestParam("id") int id) ;
	
	/**
	 * 查询所有评委
	 * @return
	 */
	
	@GetMapping("/manager/roleid")
	public Result findExportByRoleId() ;
	
	@DeleteMapping("/manager/exportdelete/{name}")
	public Result DeleteExportByName(@PathVariable("name")  String name) ;
	
}
