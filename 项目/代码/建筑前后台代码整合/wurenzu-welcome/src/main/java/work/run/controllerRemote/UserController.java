package work.run.controllerRemote;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import work.run.ServiceRemote.UserServiceRemote;
import work.run.util.Constant;
import work.run.util.FileUtil;
import work.run.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
@RestController
public class UserController {
//	@Value("${file.uploader.dir}")
//    private String uploadDir;
	
	@Autowired
	UserServiceRemote remote;
	
	
	@PutMapping("/user/add")
	public Result addUser(@RequestParam("name") String name,@RequestParam("password") String password) {		
		return  remote.addUser(name, password);
	}
	
	@PostMapping("/user/login")
	public Result login(@RequestParam("name") String name,@RequestParam("password") String password) {
		
		return  remote.login(name, password);
	}
	
	@PutMapping("/user/updatePass")
	public Result updatePass(@RequestParam("password") String password,@RequestParam("id") Integer id) {
		return  remote.updatePass(password, id);
	}
	
	@PutMapping("/user/updateAlloutPass")
	public Result updateAllOutPass(@RequestParam("firmName") String firmName,@RequestParam("firmDetail")  String firmDetail, @RequestParam("email") String email,  @RequestParam("phone") String phone, @RequestParam("represent") String represent, @RequestParam("address") String address, @RequestParam("id") Integer id) {
		return remote.updateAllOutPass(firmName, firmDetail, email, phone, represent, address, id);
	}
	
	//图片上传
	//修改图片
	@PostMapping("/user/updateimg")
	public Result updateimg(@RequestPart("fileimg") MultipartFile fileimg,@RequestParam("id") Integer id) {
		return remote.updateimg(fileimg, id);
	}
	
}
