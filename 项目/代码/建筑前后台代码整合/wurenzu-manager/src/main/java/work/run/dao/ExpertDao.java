package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import work.run.pojo.Manager;

@Mapper
public interface ExpertDao {
	
	
	@Insert("insert into manager(name,sex,password,salt,image,details,phone,email,roleid) "
	 + "values(#{name},#{sex},#{password},#{salt},#{image},#{details},#{phone},#{email},#{roleid})")
	public int addExport(@Param("name") String name,@Param("sex") String sex,@Param("password") String password,
			               @Param("salt") String salt,@Param("image") String image,@Param("details") String details,@Param("phone") String phone,@Param("email") String email,@Param("roleid") int roleid);
	
	
	
	@Select("select id,name,password,nick_name,sex,signature,image,regtime,salt,roleid,details,phone,email from "
			+ "manager where roleid = #{roleid} ")
	public List<Manager> selectExportByRoleId(@Param("roleid") int roleid);
	
	@Delete("delete from manager where name=#{name}")
	public int deleteExportByName(@Param("name") String name);
	
	@Update("update manager set name =#{name},sex=#{sex},password =#{password},"
			+ "salt=#{salt},details =#{details},phone=#{phone},email=#{email} where id=#{id}")
	public int updateExportById(@Param("name") String name,@Param("sex") String sex,@Param("password") String password,
            @Param("salt") String salt,@Param("details") String details,@Param("phone") String phone,@Param("email") String email,@Param("id") Integer id);
	
	/**
	 * 通过评委id查找专家
	 * @param name
	 * @return
	 */
	
	@Select("select id,name,password,nick_name,sex,signature,image,regtime,salt,roleid,phone,email from "
			+ "manager where id = #{id} ")
	public Manager findExpertById(@Param("id") Integer id) ;
	
	
	@Select("select count(*) from manager where roleid=2")
	public int  findExpertCount() ;

}
