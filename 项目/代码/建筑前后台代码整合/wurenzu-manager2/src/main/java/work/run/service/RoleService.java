package work.run.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import work.run.dao.RoleDao;
import work.run.pojo.Menu;
import work.run.pojo.Role;
import work.run.util.Constant;
import work.run.util.Result;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	RoleDao dao;
	public Result showRole(int userid) {
		Result result = new Result();
		
		
		
		Role role = dao.findRoleByUserid(userid);
		
		result.setCode(Constant.OK); //0
		result.setMsg(Constant.QUERY_IS_OK); 
		result.setData(role);
		
		return result;
	}
	
	

}
