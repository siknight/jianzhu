package work.run.service;

import java.util.HashMap;

import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import work.run.dao.UserDao;
import work.run.pojo.User;
import work.run.util.Constant;
import work.run.util.PasswordUtil;
import work.run.util.Result;

/**
 * 用户相关服务
 * 
 * @author Think
 *
 */

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	/**
	 * 注册
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public Result addUser(String name, String password) {
		Result result = new Result();
		// 判断参数是否符合规则
		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}

		// 判断数据库中是否已经有该用户
		if (dao.findUserByName(name) != null) {
			result.setCode(Constant.error02); // 1
			result.setMsg(Constant.USER_IS_EXIT);
			return result;
		}
		User user = new User();
		// 加盐
		String salt = PasswordUtil.salt();
		// 密码加密
		String md5 = PasswordUtil.md5(password + salt);
		user.setName(name);
		user.setPassword(md5);
		user.setSalt(salt); // 把盐存进去
		dao.insert(name, md5,salt);
		result.setCode(Constant.OK); // 0
		result.setMsg(Constant.REGISTER_OK_MSG);
		result.setData(user);
		return result;
	}

	/**
	 * 
	 * 登陆
	 * 
	 * @param name
	 * @param password
	 * @return
	 */

	public Result login(String name, String password) {
		Result result = new Result();
		// 判断参数是否符合规则
		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}

		// 判断数据库中是否有该用户
		User user = dao.findUserByName(name);
		if (user == null) {
			result.setCode(Constant.error02); // 1
			result.setMsg(Constant.LOGIN_USER_IS_NOT_EXIT);
			return result;
		}

		// 加密比较
		String md5 = PasswordUtil.md5(password + user.getSalt());
		 //密码错误
		if (!user.getPassword().equals(md5)) {
			result.setCode(Constant.error03); //2
			result.setMsg(Constant.PASSWORD_ERROR);
			return result;
		}
		// 登陆成功
		result.setCode(Constant.OK); // 0
		result.setMsg(Constant.LOGIN_SUCCESS);
		user.setPassword(password);
		result.setData(user);
		return result;

	}
	
	
	/**
	 * 修改
	 * @param name
	 * @param password
	 * @param nick_name
	 * @param sex
	 * @param signature
	 * @param id
	 * @return
	 */
	
	//通过id修改密码
	public Result updatePassbyId(String password,Integer id) {
		Result result = new Result();
		if(StringUtils.isEmpty(password) || StringUtils.isEmpty(id)) {
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}
		// 判断数据库中是否有该用户
		User user = dao.findUserById(id);
		if (user == null) {
			result.setCode(Constant.error02); // 1
			result.setMsg(Constant.LOGIN_USER_IS_NOT_EXIT);
			return result;
		}
		//加密比较
		String salt = PasswordUtil.salt();
		String md5 = PasswordUtil.md5(password + salt);
		dao.updatePassById(md5, salt, id);//这里最好判断下
		user.setPassword(password);
		result.setCode(Constant.OK); // 0
		result.setMsg("密码修改成功！");
		result.setData(user);
		return result;
	}
	
	//通过id 修改个人信息
	public Result updateAllOutPass(String firmName, String firmDetail, String email, String phone
			 ,String represent, String address, Integer id) {
		Result result = new Result();
		if(StringUtils.isEmpty(id)) {
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}
		// 判断数据库中是否有该用户
		User user = dao.findUserById(id);
		if (user == null) {
			result.setCode(Constant.error02); // 1
			result.setMsg(Constant.LOGIN_USER_IS_NOT_EXIT);
			return result;
		}
		dao.updateAllOutPass(firmName, firmDetail, email, phone, represent, address, id);//最好判断下
		user = new User(id, user.getName(), user.getPassword(),user.getImage(), user.getRegtime(), user.getSalt(), firmName, firmDetail, email, phone, represent, address);
		result.setCode(Constant.OK); // 0
		result.setMsg("个人信息修改成功");
		result.setData(user);
		return result;
	}
	
	//修改图片
	public Result updateimg(String image, Integer id) {
		Result result = new Result();
		if(StringUtils.isEmpty(id)) {
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}
		// 判断数据库中是否有该用户
		User user = dao.findUserById(id);
		if (user == null) {
			result.setCode(Constant.error02); // 1
			result.setMsg(Constant.LOGIN_USER_IS_NOT_EXIT);
			return result;
		}
		int flag = dao.updateimg(image,id);
		if(flag==1) {
			user.setImage(image);
			result.setCode(Constant.OK); // 0
			result.setMsg("公司图片改成功");
			result.setData(user);
			return result;
		}else {
			result.setCode(Constant.OK); // 0
			result.setMsg("公司图片改失败");
			result.setData(user);
			return result;
		}
		
	}

	
}
