package work.run.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import work.run.pojo.Manager;
import work.run.util.Result;

@Mapper
public interface ManagerDao {
	/**
	 * 通过用户名查找
	 * @param name
	 * @return
	 */
	
	@Select("select id,name,password,nick_name,sex,signature,image,regtime,salt,roleid,phone,email from "
			+ "manager where name = #{name} ")
	public Manager findUserByName(String name) ;
	/**
	 * 通过id查找
	 * @param name
	 * @return
	 */
	
	@Select("select id,name,password,nick_name,sex,signature,image,regtime,salt,roleid,phone,email from "
			+ "manager where id = #{id} ")
	public Manager findUserById(@Param("id") Integer id) ;
	
	/**
	 * 修改个人信息
	 * @param nick_name
	 * @param sex
	 * @param signature
	 * @param id
	 * @return
	 */
	
	 @Update("update manager set nick_name=#{nick_name},sex=#{sex}"
		 		+ ",signature=#{signature},phone=#{phone},email=#{email} where id=#{id}")
	 public int updateMyselfById(@Param("nick_name") String nick_name,
			@Param("sex") String sex,@Param("signature") String signature,@Param("phone") String phone,@Param("email") String email, @Param("id") Integer id);
	 
	 /**
	  * 修改密码
	  * @param password
	  * @param id
	  * @return
	  */
	 
	 @Update("update manager set password =#{password},salt=#{salt} where id=#{id}")
	 public int updatePasswordById(@Param("password") String password,@Param("salt") String salt, @Param("id") Integer id);
	
	
	
	

}
