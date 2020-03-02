package work.run.ServiceRemote;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import work.run.configuration.FeignMultipartSupportConfig;
import work.run.util.Result;

@FeignClient(name="USER-SERVICE",configuration=FeignMultipartSupportConfig.class)
public interface UserServiceRemote {

	
	@PutMapping("/user/add")
	public Result addUser(@RequestParam("name") String name,@RequestParam("password") String password);
	@PostMapping("/user/login")
	public Result login(@RequestParam("name") String name,@RequestParam("password") String password) ;
	
	@PutMapping("/user/updatePass")
	public Result updatePass(@RequestParam("password") String password,@RequestParam("id") Integer id) ;
	
	@PutMapping("/user/updateAlloutPass")
	public Result updateAllOutPass(@RequestParam("firmName") String firmName,@RequestParam("firmDetail")  String firmDetail, @RequestParam("email") String email,  @RequestParam("phone") String phone, @RequestParam("represent") String represent, @RequestParam("address") String address, @RequestParam("id") Integer id);
	//图片上传
	//修改图片
	@PostMapping(value="/user/updateimg",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result updateimg(@RequestPart("fileimg") MultipartFile fileimg,@RequestParam("id") Integer id) ;
	
}
