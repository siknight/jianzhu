package work.run.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;

import work.run.dao.ExpertDao;
import work.run.dao.ExpertScoreDao;
import work.run.dao.FirmUserdao;
import work.run.dao.WorkDao;
import work.run.pojo.ExpertScore;
import work.run.pojo.Firmuser;
import work.run.pojo.Manager;
import work.run.pojo.Race;
import work.run.pojo.Work;
import work.run.util.Constant;
import work.run.util.Result;

@Service
@Transactional
public class WorkService {
	@Autowired
	WorkDao workdao;

	@Autowired
	FirmUserdao firmUserDao;

	@Autowired
	ExpertScoreDao expertScoreDao;

	@Autowired
	ExpertDao expertDao;

	/**
	 * 通过状态码查询work作品
	 * 通过work里的firmuserid查询提交的user，通过expertscore表里的workid查询每个评委给每个作品的分数
	 */

	public Result findAllWorkByStatus(Integer status) {
		Result result = new Result();

		if (StringUtils.isEmpty(status)) {
			result.setCode(Constant.error01);
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}

		// 状态为1表示该作品还没有被评奖，0表示已过期
		List<Work> works = workdao.findAllWork(status);

		if (StringUtils.isEmpty(works)) {
			result.setCode(Constant.error02); // 1
			result.setMsg(Constant.QUERY_IS_FAIL);
			return result;
		}

		// 得到作品的提交公司

		for (int i = 0; i < works.size(); i++) {
			int firmUserid = works.get(i).getFirmUserid(); // 获得userid
			Firmuser firmuser = firmUserDao.findFirmUserById(firmUserid); // 通过userid获取firmuser
			works.get(i).setFirmuser(firmuser);

		}

		System.out.println("works=" + works);

		// 得到评委
		//步骤分析  首先找到第一个作品  然后通过第一个作品找到作品的id
		//然后通过作品id找到第三方表 
		//然后遍历这个表
		//找到专家id  如果专家不存在 就跳过本次循环
		//如果存在就获取managerid
		//通过managerid和workid找到分数类
		//通过分数类找到这个分
		//然后将这个分set到manager里
		//然后用list将这个manager存进去  然后将这个list一下放到这个work里
		
		for (int i = 0; i < works.size(); i++) {
			int workid = works.get(i).getWorkid();  //先得到作品id
			System.out.println("workid="+workid);
			List<ExpertScore> expertScore = expertScoreDao.findExpertIdByWorkid(workid);  //通过作品id获取第三方类
			List<Manager> managerList = new ArrayList();
			for (int j = 0; j < expertScore.size(); j++) { // 循环获取的manager，逐渐获取
				int managerid = expertScore.get(j).getManagerid();  //获取managerid
				System.out.println("managerid的值：" + managerid);
				Manager manager = expertDao.findExpertById(managerid); // 取得相应的manager
				if (StringUtils.isEmpty(manager)) {
					continue;  //如果找不到这个manager了 循环下一个
				}
				int id = manager.getId();  //获取managerid
				System.out.println("managerid2的值：" + id);
				ExpertScore expertScore2 = expertScoreDao.findExpertScoreByExpertIdAndWorkid(id, workid); // 获取对应的分数
				System.out.println("expertScore2="+expertScore2.getExpertscore());  //取得值
				manager.setExpertScore(expertScore2);  //存入这个manager里
				managerList.add(manager);   //将每一个评委先放进这个list集合里
				System.out.println("managerList="+managerList);  //这里正确
			} 
			System.out.println("i="+i);  
			works.get(i).setExports(managerList);  //将多个评委放进去  得到第几个然后将这个专家放进去
			System.out.println("works01="+works.get(i));

		}
		System.out.println("works2="+works);
		result.setCode(Constant.OK);
		result.setMsg(Constant.QUERY_IS_OK);
		result.setData(works);
		System.out.println("result="+result);
		return result;

	}
	
	

	/**
	 * 通过状态码查询work作品 分页显示
	 */

	public Result findAllWorkByStatusAndPage(Integer pageNum, Integer status) {
		Result result = new Result();

		if (StringUtils.isEmpty(status)) {
			result.setCode(Constant.error01);
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}
		
		   // 知道了作品的大小 看是否评完算法：每个作品要每个评委都给分
		// 假设现在有五个作品 三个评委(这个评委必须现在在Manger表中,而不是被删除),评完依据就是每个作品有这三个评委评论
		// 也就是这个作品共打分了15次（3*5）
		// 步骤：1.首先要获取作品的数量 worksize （已完成）
		// 2.然后查出评委的数量 expertsize（已完成）
		// 3.然后计算worksize*expertsize（已完成）
		// 4.查出expertscore表和目前expert(expert可能被管理员删除 这个要注意)对应的行有多少
		// 5.用3和4计算的结果比较 如果想等，则表示已经评分完，否则没有评分完
		// 6.评分完则可以计算排名，否则还不能计算(尽量让没有评完的评委和作品显示出来)
		List<Work> works2 = workdao.findAllWork(status);
		int size = works2.size();
		
		
			
			
		
		PageHelper.startPage(pageNum, 1);
		// 状态为1表示该作品还没有被评奖，0表示已过期
		List<Work> works = workdao.findAllWork(status);

		if (StringUtils.isEmpty(works)) {
			result.setCode(Constant.error02); // 1
			result.setMsg(Constant.QUERY_IS_FAIL);
			return result;
		}

		for (int i = 0; i < works.size(); i++) {
			int firmUserid = works.get(i).getFirmUserid(); // 获得userid
			Firmuser firmuser = firmUserDao.findFirmUserById(firmUserid); // 通过userid获取firmuser
			works.get(i).setFirmuser(firmuser);
			works.get(i).setPagesize(size);

		}
		System.out.println("works=" + works);

		for (int i = 0; i < works.size(); i++) {
			int workid = works.get(i).getWorkid();
			List<ExpertScore> expertScore = expertScoreDao.findExpertIdByWorkid(workid);
			List<Manager> managerList = new ArrayList();
			for (int j = 0; j < expertScore.size(); j++) { // 循环获取的manager，逐渐获取
				int managerid = expertScore.get(j).getManagerid();
				System.out.println("managerid的值：" + managerid);
				Manager manager = expertDao.findExpertById(managerid); // 取得相应的manager
				if (StringUtils.isEmpty(manager)) {
					continue;
				}
				int id = manager.getId();
				System.out.println("managerid2的值：" + id);
				ExpertScore expertScore2 = expertScoreDao.findExpertScoreByExpertIdAndWorkid(id, workid); // 获取对应的分数
				manager.setExpertScore(expertScore2);
				managerList.add(manager);
			}
			works.get(i).setExports(managerList);

		}

		System.out.println("works=" + works);
		result.setCode(Constant.OK);
		result.setMsg(Constant.QUERY_IS_OK);
		result.setData(works);
		return result;

	}
	
	
	/**
	 * 通过状态码查询work作品 降序分页显示
	 */

	public Result findAllWorkByStatusAndPageAndRow(Integer pageNum, Integer status) {
		Result result = new Result();

		if (StringUtils.isEmpty(status)) {
			result.setCode(Constant.error01);
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}
		
		   // 知道了作品的大小 看是否评完算法：每个作品要每个评委都给分
		// 假设现在有五个作品 三个评委(这个评委必须现在在Manger表中,而不是被删除),评完依据就是每个作品有这三个评委评论
		// 也就是这个作品共打分了15次（3*5）
		// 步骤：1.首先要获取作品的数量 worksize （已完成）
		// 2.然后查出评委的数量 expertsize（已完成）
		// 3.然后计算worksize*expertsize（已完成）
		// 4.查出expertscore表和目前expert(expert可能被管理员删除 这个要注意)对应的行有多少
		// 5.用3和4计算的结果比较 如果想等，则表示已经评分完，否则没有评分完
		// 6.评分完则可以计算排名，否则还不能计算(尽量让没有评完的评委和作品显示出来)
		List<Work> works2 = workdao.findAllWorkRow(status);   //
		int size = works2.size();
		
		
		
			
			
		
		PageHelper.startPage(pageNum, 1);
		// 状态为1表示该作品还没有被评奖，0表示已过期
		List<Work> works = workdao.findAllWorkRow(status);            //

		if (StringUtils.isEmpty(works)) {
			result.setCode(Constant.error02); // 1
			result.setMsg(Constant.QUERY_IS_FAIL);
			return result;
		}

		for (int i = 0; i < works.size(); i++) {
			int firmUserid = works.get(i).getFirmUserid(); // 获得userid
			Firmuser firmuser = firmUserDao.findFirmUserById(firmUserid); // 通过userid获取firmuser
			works.get(i).setFirmuser(firmuser);
			works.get(i).setPagesize(size);

		}
		System.out.println("works=" + works);

		for (int i = 0; i < works.size(); i++) {
			int workid = works.get(i).getWorkid();
			List<ExpertScore> expertScore = expertScoreDao.findExpertIdByWorkid(workid);
			List<Manager> managerList = new ArrayList();
			for (int j = 0; j < expertScore.size(); j++) { // 循环获取的manager，逐渐获取
				int managerid = expertScore.get(j).getManagerid();
				System.out.println("managerid的值：" + managerid);
				Manager manager = expertDao.findExpertById(managerid); // 取得相应的manager
				if (StringUtils.isEmpty(manager)) {
					continue;
				}
				int id = manager.getId();
				System.out.println("managerid2的值：" + id);
				ExpertScore expertScore2 = expertScoreDao.findExpertScoreByExpertIdAndWorkid(id, workid); // 获取对应的分数
				manager.setExpertScore(expertScore2);
				managerList.add(manager);
			}
			works.get(i).setExports(managerList);

		}

		System.out.println("works=" + works);
		result.setCode(Constant.OK);
		result.setMsg(Constant.QUERY_IS_OK);
		result.setData(works);
		return result;

	}
	
	

}
