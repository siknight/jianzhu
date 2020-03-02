package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.junit.runners.Parameterized.Parameters;

import work.run.pojo.Work;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface WorkDao {
	
	//提交作品,期数必须是最新的
	 @Insert("insert into work(workname,imgUrl,firmUserid,details,period,status) values(#{workname},#{imgUrl},#{firmUserid}"
	 		+ ",#{details},#{period},1)")
	 int insert(@Param("workname") String workname,@Param("imgUrl") String imgUrl,
			 @Param("firmUserid") Integer firmUserid, @Param("details") String details,@Param("period") Integer period);
	
	 
	//根据 期数 查询所有参赛作品 可能用户去查询往期的参赛作品 作品失效时status=0
	 @Select("SELECT workid,workname,imgUrl,grade,firmUserid,details,period,STATUS FROM WORK WHERE  period=#{period} "
		 		+ "ORDER BY grade DESC" )
	 public List<Work> findAllByPeriod(@Param("period") Integer period);
	
	 //根据 期数 查询获奖作品 默认获奖作品是平均分排名3的那几个
	 @Select("SELECT workid,workname,imgUrl,grade,firmUserid,details,period,STATUS FROM WORK WHERE  period=#{period}"
	 		+ " ORDER BY period DESC , grade DESC LIMIT 0,#{number}" )
	 public List<Work> findWinByPeriod(@Param("period") Integer period,@Param("number") Integer number);
	 
	 //查询 每期 排名 前三的参赛作品
	 @Select("SELECT workid,workname,imgUrl,grade,firmUserid,details,period,STATUS FROM WORK t  WHERE  " +  
	 		"  status=0 and  (SELECT COUNT(1)+1 FROM WORK WHERE period=t.period AND grade>t.grade)" + 
	 		"    <=  3 ORDER BY period DESC,grade DESC")
	 public List<Work> findAllWinByPeriodRank();
	 
	 
	 
	 //查询最新期的参赛作品,因为有可能最新一期的比赛虽然发布了，但最新一期的作品没有做出来
	 @Select("select workid,workname,imgUrl,grade,firmUserid,details from work where  period = (select MAX(period) from raceinfo) order by grade desc")
	 public List<Work> findAllByMaxPeriod();
	 
	 
	 //根据用户id查询参赛作品 如果用户的作品被管理员下架，考虑是不是让用户知道一下 
	 //规定一个公司一期只能提交一个作品，所以这里查询出来的只有一个
	 @Select("select workid,workname,imgUrl,grade,firmUserid,details,period,status from work where  firmUserid=#{firmUserid} order by period desc,grade desc")
	 public Work findAllByFirmUserId(@Param("firmUserid") Integer firmUserid);
	 

	 //查询展品 个人觉得每年最优秀的才能勉强评为展品，这里没有展品表，暂时就认为每期最优秀的是展品
	 @Select("select workid,workname,imgUrl,grade,firmUserid,details,period,status from work a where a.grade in"
	 		+ "(select MAX(grade) from work b where a.period=b.period order by grade desc)")
	 public List<Work> findAllExhibits();
	 

	 //查询所有参赛作品 根据 期数 分数排序
	 @Select("SELECT workid,workname,imgUrl,grade,firmUserid,details,period,STATUS FROM WORK "
		 		+ "ORDER BY period DESC" )
	 public List<Work> findAll();
	 
	 
	 //根据期数查询企业上传了几个作品
	 //主要是规定了一个企业每一期只能上传一个作品
	 @Select("SELECT count(*) num from work where period=#{period} and firmUserid=#{firmUserid}")
	 public int findcontByPeriodFirm(@Param("period") Integer period,@Param("firmUserid") Integer firmUserid);
}
