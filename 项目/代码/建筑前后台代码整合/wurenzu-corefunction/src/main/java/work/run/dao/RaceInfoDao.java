package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import work.run.pojo.RaceInfo;

@Mapper
public interface RaceInfoDao {
	//查询最新发布的比赛信息
	@Select("SELECT id,raceName,details,period,status FROM raceinfo WHERE period = (SELECT MAX(period) FROM raceinfo) ")
	public 	List<RaceInfo> findRaceInfoByMaxPeriod();

	//根据 期数 查询发布的比赛信息
	@Select("select id,raceName,details,period,status from "
			+ "raceinfo where period = #{id} ")
	public 	List<RaceInfo> findRaceInfoByPeriod(@Param("id")int id);
	
	//查询最新一期的数字
	@Select("SELECT MAX(period) FROM raceinfo")
	public Integer findMaxPeriod();
	
	@Select("select status from raceinfo where period=#{period}")
	public Integer findMaxStatus(@Param("period") Integer period);
}
