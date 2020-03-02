package work.run.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import work.run.dao.ManagerDao;
import work.run.pojo.Manager;

import work.run.util.Constant;
import work.run.util.PasswordUtil;
import work.run.util.Result;
import work.run.util.UserManager;

/**
 * 用户相关服务
 * @author Think
 *
 */

@Service
@Transactional
public class ManagerService {
	@Autowired
	ManagerDao dao;
	
	@Autowired
	private UserManager userManager;

	
	
	/**
	 * 
	 * 登陆
	 * @param name
	 * @param password
	 * @return
	 */
	
	public Result login(String name,String password) {
		Result result = new Result();
		//判断参数是否符合规则
		if(StringUtils.isEmpty(name)||StringUtils.isEmpty(password)) { 
			result.setCode(Constant.error01);  //-1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}	
		
		
		//判断数据库中是否有该用户
		Manager manager = dao.findUserByName(name);
		if(manager==null) {
			result.setCode(Constant.error02); //1
 			result.setMsg(Constant.LOGIN_USER_IS_NOT_EXIT);
			return result;
		}	
		
		//加密比较
		String md5 = PasswordUtil.md5(password+manager.getSalt());
		//密码错误
		if(!manager.getPassword().equals(md5)) {
			result.setCode(Constant.error03); //2
			result.setMsg(Constant.PASSWORD_ERROR);
			return result;
		}
		//登陆成功
		
		//通过用户id创建一个令牌token
		String token = userManager.createToken(manager.getId()); //创建一个token
		manager.setToken(token);   
		
		result.setCode(Constant.OK); //0
		result.setMsg(Constant.LOGIN_SUCCESS);	
		result.setData(manager);	
		
		return result;
		
		
	}
	
	
	/**
	 * 修改基本信息
	 * @param name
	 * @param password
	 * @param nick_name
	 * @param sex
	 * @param signature
	 * @param id
	 * @return
	 */

	public Result updateById( String nick_name, String sex, String signature, String phone, String email, Integer id) {
		Result result = new Result();
		// 判断参数是否符合规则
		if ( StringUtils.isEmpty(nick_name)
				|| StringUtils.isEmpty(sex) || StringUtils.isEmpty(signature) || StringUtils.isEmpty(id)) {
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}
		// 判断数据库中是否有该用户
		Manager manager = dao.findUserById(id);
		
		if (manager == null) {
			result.setCode(Constant.error02); // 1
			result.setMsg(Constant.LOGIN_USER_IS_NOT_EXIT);
			return result;
		}
		// 公共返回
		
		dao.updateMyselfById(nick_name, sex, signature,phone,email, id);
		result.setCode(Constant.OK); // 0
		result.setMsg(Constant.UPDATE_OK);
		manager.setNick_name(nick_name);
		manager.setSex(sex);
		manager.setSignature(signature);
		result.setData(manager);
		return result;
	}

	/**
	 * 修改密码
	 * @param oldPassword
	 * @param password
	 * @param id
	 * @return
	 */
	
	public Result updatePasswordById(String oldPassword ,String password,  Integer id) {
		Result result = new Result();
		// 判断参数是否符合规则
		if (StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(password) || StringUtils.isEmpty(id)) {
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}
		// 判断数据库中是否有该用户
		Manager manager = dao.findUserById(id);
		
		if (manager == null) {
			result.setCode(Constant.error02); // 1
			result.setMsg(Constant.LOGIN_USER_IS_NOT_EXIT);
			return result;
		}
		String salt2 = manager.getSalt();
		/**
		 * 旧密码错误
		 */
		if(!manager.getPassword().equals(PasswordUtil.md5(oldPassword+salt2))) {
			result.setCode(Constant.error03); // 2
			result.setMsg(Constant.OLDPASSWORD_IS_ERROR);
			return result;
		}
		// 公共返回
		String salt = PasswordUtil.salt();
		String md5 = PasswordUtil.md5(password+salt);
		
		dao.updatePasswordById(md5,salt, id);
		result.setCode(Constant.OK); // 0
		result.setMsg(Constant.UPDATE_OK);
	
		return result;
	}

	
	
	/**
	 *  用于身份验证
	 *  userId 用户的id
	 *  token 浏览器存储的token
	 */
	
	public Result checkToken(Integer userId, String token) {
		// TODO Auto-generated method stub
		Result result = new Result();
		//参数检查s
		if(userId!=null&&token!=null&&!"".equals(token)){
			//检查身份
			boolean ok = userManager.checkToken(userId, token);
			if(ok){
				//成功
				result.setCode(Constant.OK);
				result.setMsg(Constant.QUERY_IS_OK);
				return result;
			}
		}
		//失败
		result.setCode(Constant.error02); //1
		result.setMsg(Constant.QUERY_IS_FAIL);
		return result;
		
	}

	

}
