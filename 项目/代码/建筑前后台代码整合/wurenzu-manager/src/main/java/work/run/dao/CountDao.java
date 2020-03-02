package work.run.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import work.run.pojo.Count;
@Mapper
public interface CountDao {
	@Select("select count(*) as firmusercount , count(distinct firmUserid) as firmworkcount from firmuser,work")
	public List<Count> count();
}
