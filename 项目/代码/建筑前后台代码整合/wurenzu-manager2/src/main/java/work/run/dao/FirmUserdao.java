package work.run.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import work.run.pojo.Firmuser;

@Mapper
public interface FirmUserdao {

	@Select("select id,name,image,firmName,firmDetail,email,phone,represent,address from firmuser  where id=#{id}")
	public Firmuser findFirmUserById(@Param("id") Integer id);
}
