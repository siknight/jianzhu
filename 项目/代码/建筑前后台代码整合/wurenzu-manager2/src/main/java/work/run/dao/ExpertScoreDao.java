package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import work.run.pojo.ExpertScore;

@Mapper
public interface ExpertScoreDao {
	
	//通过评委id和作品id查看每个评委的对每个评委的作品,然后通过managerid查询评委
	@Select("select id,expertscore,managerid,workid from expertscore_manager where managerid =#{managerid} and workid=#{workid} ")
	public ExpertScore findExpertScoreByExpertIdAndWorkid(@Param("managerid") Integer managerid,@Param("workid")  Integer workid);
	//通过作品id查看作品对应的每个评委
	@Select("select id,expertscore,managerid,workid from expertscore_manager where  workid=#{workid} ")
	public List<ExpertScore> findExpertIdByWorkid(@Param("workid") Integer workid);

	@Insert("insert into expertscore_manager(expertscore,managerid,workid) values(#{expertscore},#{managerid},#{workid})")
	public int addScore(@Param("expertscore") Integer expertscore,@Param("managerid") Integer managerid,@Param("workid") Integer workid);
	
	
	//通过作品id查看作品对应的每个评委分数
	@Select("select expertscore from expertscore_manager where  workid=#{workid} ")
	public List<Integer> findAllWoksScore(Integer workid);
}
