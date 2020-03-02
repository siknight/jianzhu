package work.run.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import work.run.dao.CountDao;
import work.run.pojo.Count;
import work.run.util.Constant;
import work.run.util.Result;
@Service
public class CountService {
	@Autowired
	CountDao countDao;
	public Result count() {
		Result result = new Result();
		List<Count> list = countDao.count();
		result.setCode(Constant.OK);
		result.setMsg(Constant.QUERY_IS_OK);
		result.setData(list);
		
		return result;
	}
}
