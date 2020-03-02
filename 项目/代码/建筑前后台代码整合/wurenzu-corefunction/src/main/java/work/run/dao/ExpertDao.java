package work.run.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import work.run.pojo.Expert;


@Mapper
public interface ExpertDao {
	//查询所有的专家 这里最好从角色表中查询角色名称为专家的，因为有可能角色表被管理员修改
	//不过这种的一般都不可能修改，这是属于常量的那一种
	//个人觉得如果是要限制用户的访问级别的话，可以采用查询视图的方式
	 @Select("select id,name,sex,signature,image,details from manager where roleid=2")
	 public List<Expert> findAll();
	 
	 //根据id 查询单个专家详情
	 @Select("select id,name,sex,image,details from manager where roleid=2 and id=#{id}")
	 public Expert findById(@Param("id") Integer id);
	 
	 //根据名称查询
	 @Select("select id,name,sex,image,details from manager where roleid=2 and name=#{name}")
	 public List<Expert> findByName(@Param("name") String name);
	 
	 //根据名称模糊查询
	 @Select("select id,name,sex,image,details from manager where roleid=2 and name like CONCAT('%',#{name,jdbcType=VARCHAR},'%')")
	 public List<Expert> findByNameLike(@Param("name") String name);
	 
	 //根据id 模糊查询,这种方式只能查询 id开头的，比如说如果下边参数值为1，那么返回的结果是id为1****...的数据，没有1
	 @Select("select id,name,sex,image,details from manager where roleid=2 and id like CONCAT('%',#{id,jdbcType=INTEGER},'%')")
	 public List<Expert> findByIdLike(@Param("id") Integer id);
	 
	 
	 //考虑是不是要把专家的状态写上，因为不排除专家离职啥的
	 //这样就可以根据专家的状态查询，这样查询出来的肯定是要给作品打分的专家，而不是没有权限的专家

}
