package work.run.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import work.run.dao.ExpertDao;
import work.run.dao.ManagerDao;
import work.run.dao.RedisDao;
import work.run.pojo.Manager;
import work.run.util.Constant;
import work.run.util.FileUtil;
import work.run.util.PasswordUtil;
import work.run.util.Result;

@Service
@Transactional
public class ExpertService {

	@Autowired
	ExpertDao expertDao;

	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	RedisDao redisDao;
	
	/**
	 * 添加评委
	 * @param name
	 * @param sex
	 * @param password
	 * @param details
	 * @return
	 */

	public Result addExport(String name,String sex,String password, String image,String details,String phone,String email) {
		Result result = new Result();
		// 判断参数是否符合规则
		if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}

		// 判断数据库中是否有该用户
		Manager manager = managerDao.findUserByName(name);
		if (manager != null) {
			result.setCode(Constant.error03); // 2
			result.setMsg(Constant.USER_IS_EXIT); // 用户已经存在
			return result;
			
		}
		
		 String salt = PasswordUtil.salt();
		 String md5 = PasswordUtil.md5(password+salt);
		
		  int i= expertDao.addExport(name,sex,md5,salt, image,details,phone,email, 2);
		  if(i>0) {

			   result.setCode(Constant.OK); // 2
			   result.setMsg(Constant.ADD_OK); // 添加成功
			   HashMap<String, String> imagemap = new HashMap<String, String>();
			   imagemap.put("img", image);
			   result.setData(imagemap);
			   redisDao.removeObject("selectExportByRoleId2");  //移除redis缓存
		  }
		
		

		return result;

	}
	
	
	/**
	 * 查找评委通过roleid
	 * @param roleid
	 * @return
	 */
	
	public Result selectExportByRoleId(Integer roleid) {
		Result result = new Result();
		// 判断参数是否符合规则
		if (StringUtils.isEmpty(roleid)) {
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}

		// redis读取
		Result result2 = (Result) redisDao.getObject("selectExportByRoleId" + roleid);
		if (!StringUtils.isEmpty(result2)) {
			return result2;
		}
		List<Manager> list = expertDao.selectExportByRoleId(roleid);
		result.setCode(Constant.OK);
		result.setMsg(Constant.QUERY_IS_OK);
		result.setData(list);
		redisDao.saveObject("selectExportByRoleId2", result); // redis缓存
		return result;

	}
	
	/**
	 * 删除专家
	 * @param id
	 * @return
	 */
	
	public Result deleteExportByName(String name) {
		Result result = new Result();
		// 判断参数是否符合规则
		if (StringUtils.isEmpty(name) ){
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}

		
		int i = expertDao.deleteExportByName(name);
		if(i>0) {
			result.setCode(Constant.OK);
			result.setMsg(Constant.DELETE_OK);
			redisDao.removeObject("selectExportByRoleId2");  //移除redis缓存
		}
		
		
		return result;

	}
	
	/**
	 * 修改评委
	 * @param name
	 * @param sex
	 * @param Password
	 * @param details
	 * @param id
	 * @return
	 */
	
	
	public Result updateExportById(String name,String sex,String password,String details,String phone,String email,Integer id) {
		Result result = new Result();
		// 判断参数是否符合规则
		if (StringUtils.isEmpty(id) ){
			result.setCode(Constant.error01); // -1
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}
		
		String salt = PasswordUtil.salt();
		String md5 = PasswordUtil.md5(password+salt);
			
		
		int i = expertDao.updateExportById(name, sex, md5, salt, details,phone,email, id);
		if(i>0) {
			result.setCode(Constant.OK);
			result.setMsg(Constant.UPDATE_OK);
			redisDao.removeObject("selectExportByRoleId2");  //移除redis缓存
		}
		
		
		return result;

	}

}
