package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import work.run.pojo.Menu;
import work.run.pojo.Role;

@Mapper
public interface RoleDao {
	
	@Select("select * from role where roleid in(select roleid from manager where id=#{id})")
	public Role findRoleByUserid(@Param("id") Integer id);

}
