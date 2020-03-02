package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import work.run.pojo.User;
import work.run.util.Result;

@Mapper
public interface UserDao {
	/**
	 * 用于登陆
	 * @param name
	 * @return
	 */
	
	@Select("select id,name,password,image,regtime,salt,firmName,firmDetail,email,phone,represent,address from "
			+ "firmuser where name = #{name} ")
	public User findUserByName(String name);
	
	
	@Select("select id,name,password,image,regtime,salt,firmName,firmDetail,email,phone,represent,address from "
			+ "firmuser where id = #{id} ")
	public User findUserById(int id);
	
	 @Insert("insert into firmuser(name,password,salt) values(#{name},#{password},#{salt})")
	 int insert(@Param("name") String name,@Param("password") String password,@Param("salt") String salt);
	
	 

	 //通过id 修改密码
	 @Update("update firmuser set password=#{password} ,salt=#{salt} where id=#{id}")
	 int updatePassById( @Param("password") String password, @Param("salt") String salt, @Param("id") Integer id);
	 
	 //通过id 修改个人信息
	 @Update("update firmuser set firmName=#{firmName},firmDetail=#{firmDetail}"
	 		+ ",email=#{email},phone=#{phone},represent=#{represent},address=#{address} where id=#{id}")
	 int updateAllOutPass(@Param("firmName") String firmName
			 ,  @Param("firmDetail") String firmDetail  , @Param("email") String email,  @Param("phone") String phone
			 ,  @Param("represent") String represent,  @Param("address") String address,  @Param("id") Integer id);
	 
	 //通过id 修改图片
	 @Update("update firmuser set image=#{image} where id = #{id}")
	 int updateimg(@Param("image") String image, @Param("id") Integer id);
}
