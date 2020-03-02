package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import work.run.pojo.ExpertScore;
import work.run.pojo.Work;

@Mapper
public interface ExpertScoreDao {
	//根据作品id 查询作品所有专家打分
	 @Select("SELECT id,expertscore,managerid,workid FROM expertsocre_manager WHERE workid=#{workid}")
	 public List<ExpertScore> findAllByWorkId(@Param("workid") Integer workid);
	 
	 //根据专家id 查询所有作品打分 感觉拿来没用,除非作品是最新期的
//	 @Select("select id,expertscore,managerid,workid from expertsocre_manager where managerid=#{managerid}")
//	 public List<ExpertScore> findAllByExpertId(@Param("managerid") Integer managerid);
	 
	 //查询一个作品的最高分
	 @Select("SELECT id, MAX(expertscore) expertscore,managerid,workid FROM expertsocre_manager WHERE workid=#{workid}")
	 public List<ExpertScore> findOneMaxByWorkId(@Param("workid") Integer workid);
	 
	 //查询一个作品的最低分
	 @Select("SELECT id, MIN(expertscore) expertscore,managerid,workid FROM expertsocre_manager WHERE workid=#{workid}")
	 public List<ExpertScore> findOneMinByWorkId(@Param("workid") Integer workid);
	 
	 //查询一个作品的平均分
	 @Select("SELECT id, avg(expertscore) expertscore,managerid,workid FROM expertsocre_manager WHERE workid=#{workid}")
	 public List<ExpertScore> findOneAverageByWorkId(@Param("workid") Integer workid);
	 
	 //查询某期作品的所有专家打分和平均分
	 
	 //查询所有作品的最高分
	 
	 //查询所有作品的最低分
	 
	 //查询作品总分前几？
	 
	 //查询作品总分倒数几？
	 
	 //根据 user 查询 作品总分最高
	 
	 //根据 user 查询 作品总分最后

}
