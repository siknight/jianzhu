package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import work.run.pojo.Race;

@Mapper
public interface RaceDao {
	
	@Insert("insert into raceinfo(raceName,details,status,period,imgUrl) "
			 + "values(#{raceName},#{details},#{status},#{period},#{imgUrl})")
	public int  addRace(@Param("raceName") String raceName,
			@Param("details") String details,@Param("status") Integer status,@Param("period") Integer period,@Param("imgUrl") String imgUrl);
	
	@Delete("delete from raceinfo where status=#{status}")
	public int deleteRace(@Param("status") Integer status);
	
	
	@Select("select id,raceName,details,period,status,imgUrl from raceinfo ")
	public List<Race> findRace();
	
//	@Select("select id,raceName,details,period,status from raceinfo where period in (select max(period) from raceinfo)  and status=#{status} ")
//	public Race finRaceByStatus(@Param("status") Integer status);
	
	@Select("select id,raceName,details,period,status,imgUrl from raceinfo where  status=#{status} ")
	public Race finRaceByStatus(@Param("status") Integer status);
	
	@Select("select id,raceName,details,period,status,imgUrl from raceinfo where  status=#{status} ")
	public List<Race> finHistoryRaceByStatus(@Param("status") Integer status);
	
	@Update("update raceinfo set raceName =#{raceName},details=#{details},period=#{period},status=#{status} where id=#{id}")
	public int  updateRaceById(@Param("raceName") String raceName,
			@Param("details") String details,@Param("period") Integer period,@Param("status") Integer status,@Param("id") Integer id);
	
	@Update("update raceinfo set status=0 where id=#{id}")
	public int  stopRaceById(Integer id);

}
