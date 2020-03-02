package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import work.run.pojo.Menu;

@Mapper
public interface MenuDao {
	
	
	@Select("select menuid,pid,menuname,url from menu where pid=#{pid} and menuid in(select menuid from role_menu where roleid in(select roleid from manager where id=#{id}))")
	public List<Menu> findMenuByUserid(@Param("pid") Integer pid,@Param("id") Integer id);
	
	
	
	

}
