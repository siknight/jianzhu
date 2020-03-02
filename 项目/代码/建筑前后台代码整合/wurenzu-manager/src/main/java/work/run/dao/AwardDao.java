package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import work.run.pojo.Award;
import work.run.pojo.Manager;
import work.run.pojo.Work;

@Mapper
public interface AwardDao {
	// 添加奖项
	@Update("update award set workid =#{workid} where aid=#{aid}")
	public int updateWorkById(@Param("workid") Integer workid, @Param("aid") Integer aid);

	// 查询奖项
	@Select("select * from award where workid=#{workid}")
	public Award selectByworkId(@Param("workid") Integer workid);

	@Select("select aid,aname,price,workid from " + "award where aid = #{aid} ")
	public List<Award> selectAwardByaid(@Param("aid") int aid);

	// 查询获奖
	@Select("SELECT workid,workname,imgUrl,firmUserid,grade,details FROM work ORDER BY grade DESC LIMIT 3")
	public List<Work> selectWorkBygrade();
	
	// 将全部奖项的workid清空
		@Update("update award set workid =null ")
		public int updateWorkIdForNull();

}
