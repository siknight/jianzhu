package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import work.run.pojo.Work;

@Mapper
public interface WorkDao {
	/**
	 * 查询所有和作品有关的信息，然后通过json返回
	 * 先通过状态码查找作品, 然后通过work表里的firmuserid查找在user相关信息，在通过第三方表exportscore
	 * 通过workid查找expertid，在通过expertid查找expert表里的信息，然后通过expert表
	 * 查找的expertid和work表里查找的workid，在expertscore表里再次查找score
	 * 
	 * @param status
	 * @return
	 */
	@Select("select workid,workname,imgUrl,grade,firmUserid,details,period,status from work where status=#{status}")
	public List<Work> findAllWork(@Param("status") Integer status);
	
	@Select("select workid,workname,imgUrl,grade,firmUserid,details,period,status from work where status=#{status} order by grade desc,workid asc")
	public List<Work> findAllWorkRow(@Param("status") Integer status);
	
	@Update("update work set grade =#{grade} where workid=#{workid}")
	public int addWorkScore(@Param("grade") Integer grade,@Param("workid") Integer workid);
	
	
	@Update("update work set status =#{status} where workid=#{workid}")
	public int updateStatus(@Param("status") Integer status,@Param("workid") Integer workid);

}
