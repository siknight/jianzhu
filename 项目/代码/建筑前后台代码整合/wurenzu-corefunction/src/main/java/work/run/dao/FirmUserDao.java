package work.run.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import work.run.pojo.FirmUser;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FirmUserDao {
	
	//通过name查询参赛者
	@Select("select DISTINCT id,name,image,regtime,firmName,firmDetail,email,phone,represent,address from "
			+ "firmuser where name = #{name} ")
	public List<FirmUser> findUserByName(@Param("name") String name);
	
	//通过id查询参赛者
	@Select("select id,name,image,regtime,firmName,firmDetail,email,phone,represent,address from "
			+ "firmuser where id = #{id} ")
	public FirmUser findUserById(@Param("id") Integer id);
	
	//根据 期数 查询参赛者 嵌套查询效率太低，使用连接查询比较好
//	@Select("SELECT DISTINCT id,NAME,image,regtime,firmName,firmDetail,email,phone,represent,address FROM firmuser" + 
//			"  WHERE id IN (SELECT firmUserid FROM WORK WHERE period = #{period})")
	
	@Select("select DISTINCT id,NAME,image,regtime,firmName,firmDetail,email,phone,represent,address FROM firmuser"
			+ " as si inner join (select firmUserid from work where period =#{period}) as ci on ci.firmUserid = si.id")
	public List<FirmUser> findAllByPeriod(@Param("period") Integer period);
	
	//查询最新一期的参赛者 嵌套查询效率太低，使用连接查询比较好
	@Select("SELECT DISTINCT id,NAME,image,regtime,firmName,firmDetail,email,phone,represent,address FROM firmuser " + 
			"  WHERE id IN (SELECT firmUserid FROM WORK WHERE period = (SELECT MAX(period) FROM raceinfo));")
	public List<FirmUser> findAllByMaxPeriod();
		
    //根据name 模糊查询 某期的参赛者
	@Select("select DISTINCT id,name,image,regtime,firmName,firmDetail,email,phone,represent,address from firmuser"
			+ " where name like CONCAT('%',#{name,jdbcType=VARCHAR},'%') "
			+ "and id IN (SELECT firmUserid FROM WORK WHERE period = #{period})")
	public List<FirmUser> findByNameLike(@Param("name") String name, @Param("period") Integer period);
	
	//根据name 模糊查询 最新期的参赛者
	@Select("select DISTINCT id,name,image,regtime,firmName,firmDetail,email,phone,represent,address from firmuser"
			+ " where name like CONCAT('%',#{name,jdbcType=VARCHAR},'%') "
			+ "and id IN (SELECT firmUserid FROM WORK WHERE period = (SELECT MAX(period) FROM raceinfo))")
	public List<FirmUser> findByNameMaxPeriod(@Param("name") String name);
	
	//根据公司名 模糊查询 最新期的参赛者
	@Select("select DISTINCT id,name,image,regtime,firmName,firmDetail,email,phone,represent,address from firmuser"
			+ " where firmName like CONCAT('%',#{firmName,jdbcType=VARCHAR},'%') "
			+ "and id IN (SELECT firmUserid FROM WORK WHERE period = (SELECT MAX(period) FROM raceinfo))")
	public List<FirmUser> findByFirmMaxPeriod(@Param("firmName") String firmName);
	
	//根据公司名 模糊查询 某期的参赛者
	@Select("select DISTINCT id,name,image,regtime,firmName,firmDetail,email,phone,represent,address from firmuser"
			+ " where firmName like CONCAT('%',#{firmName,jdbcType=VARCHAR},'%') "
			+ "and id IN (SELECT firmUserid FROM WORK WHERE period = #{period})")
	public List<FirmUser> findByFirmPeriod(@Param("firmName") String firmName ,@Param("period") Integer period);
	
	
	//查询某期最高分的参赛者 建议写在service 层因为firmuser类没有grade period属性
	@Select("SELECT DISTINCT si.id,si.name,si.image,si.firmName" + 
			" FROM firmuser AS si" + 
			" INNER JOIN (SELECT firmUserid,MAX(grade)AS grade,period FROM WORK WHERE period=#{period}) AS ci" + 
			" ON ci.firmUserid = si.id")
	public FirmUser findByPeriodMaxScore(@Param("period") Integer period);
	
	//查询前几期最高分的参赛者
	@Select("SELECT DISTINCT si.id,si.name,si.image,si.firmName" + 
			" FROM firmuser AS si" + 
			" INNER JOIN (SELECT firmUserid,MAX(grade)AS grade,period FROM WORK WHERE period<=#{period} GROUP BY period) AS CI" + 
			" ON ci.firmUserid = si.id" )
	public List<FirmUser> findBySomePeriodMaxScore(@Param("period") Integer period);
	
	//查询每期最高分的参赛者
	@Select("SELECT DISTINCT si.id,si.name,si.image,si.firmName" + 
			" FROM firmuser AS si" + 
			" INNER JOIN (SELECT firmUserid,MAX(grade)AS grade,period FROM WORK GROUP BY period) AS ci" + 
			" ON ci.firmUserid = si.id;")
	public List<FirmUser> findbyAllPeriodMaxScore();

	//查询 每期 分数排名前几的参赛者
	
	//查询所有的参赛者
	@Select("SELECT DISTINCT id,NAME,image,regtime,firmName,firmDetail,email,phone,represent,address FROM firmuser" + 
			"  WHERE id IN (SELECT firmUserid FROM WORK )")
	public List<FirmUser> findAll();
}
