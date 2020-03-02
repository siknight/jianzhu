package work.run.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import work.run.dao.MenuDao;
import work.run.dao.RedisDao;
import work.run.pojo.Menu;
import work.run.util.Constant;
import work.run.util.Result;

@Service
@Transactional
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private RedisDao redisDao;
	
	
	
	public Result showMenuInfo(int id) {
		List<Menu> list = menuDao.findMenuByUserid(0, id);		
		Result result = new Result();
		if(StringUtils.isEmpty(list)) {
			result.setCode(Constant.error02); //1
			result.setMsg(Constant.QUERY_IS_FAIL); 
			return result;
		}
		
		//第二次再访问时从redis里读
		Result result2 = (Result)redisDao.getObject("showMenuInfo"+id); 
		if(!StringUtils.isEmpty(result2)) {
			System.out.println("menusredis查找成功");
			return result2;
		}
		
		for(int i=0;i<list.size();i++) {
			Menu menu = list.get(i);
			List<Menu> ziMenu = menuDao.findMenuByUserid(menu.getMenuid(), id);
			list.get(i).setZiMenu(ziMenu);
		}
		result.setCode(Constant.OK); //0
		result.setMsg(Constant.QUERY_IS_OK); 
		result.setData(list);
		
		//第一次登录查询时redis存取
		redisDao.saveObject("showMenuInfo"+id, result); 
		return result;
		
	}

}
