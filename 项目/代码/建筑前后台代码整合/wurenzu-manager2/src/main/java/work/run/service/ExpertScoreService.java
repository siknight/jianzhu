package work.run.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import work.run.dao.ExpertDao;
import work.run.dao.ExpertScoreDao;
import work.run.dao.WorkDao;
import work.run.pojo.ExpertScore;
import work.run.pojo.Manager;
import work.run.pojo.Work;
import work.run.util.Constant;
import work.run.util.Result;

@Service
@Transactional
public class ExpertScoreService {

	@Autowired
	ExpertScoreDao expertScoreDao;

	@Autowired
	WorkDao workdao;

	@Autowired
	ExpertDao expertDao;

	public Result giveScore(Integer expertscore, Integer managerid, Integer workid) {

		Result result = new Result();

		if (StringUtils.isEmpty(expertscore) || StringUtils.isEmpty(managerid) || StringUtils.isEmpty(workid)) {
			result.setCode(Constant.error01);
			result.setMsg(Constant.ARGS_IS_NULL);
			return result;
		}
		

		int i = expertScoreDao.addScore(expertscore, managerid, workid);
		if (i > 0) {
			// 每次打分计算一下是否所有评委都评完
			// 知道了作品的大小 看是否评完算法：每个作品要每个评委都给分
			// 假设现在有五个作品 三个评委(这个评委必须现在在Manger表中,而不是被删除),评完依据就是每个作品有这三个评委评论
			// 也就是这个作品共打分了15次（3*5）
			// 步骤：1.首先要获取作品的数量 worksize （已完成）
			// 2.然后查出评委的数量 expertsize（已完成）
			// 3.然后计算worksize*expertsize（已完成）
			// 4.查出expertscore表和目前expert(expert可能被管理员删除 这个要注意)对应的行有多少
			// 5.用3和4计算的结果比较 如果想等，则表示已经评分完，否则没有评分完
			// 6.评分完则可以计算排名，否则还不能计算(尽量让没有评完的评委和作品显示出来)
			List<Work> works2 = workdao.findAllWork(1);
			int size = works2.size();  //作品大小
			int expertCount = expertDao.findExpertCount(); //专家数量
			int rows = size * expertCount; // 计算总行
			int rows2 = 0; // 计算查出来的总行和上面rows做比较
			
			for (int k = 0; k < works2.size(); k++) { // 用于计算rows2
				int workid2 = works2.get(k).getWorkid();
				List<ExpertScore> expertScore = expertScoreDao.findExpertIdByWorkid(workid2);
				for (int j = 0; j < expertScore.size(); j++) { // 循环获取的manager，逐渐获取
					int managerid2 = expertScore.get(j).getManagerid();
					System.out.println("managerid的值：" + managerid2);
					Manager manager = expertDao.findExpertById(managerid2); // 取得相应的manager
					if (StringUtils.isEmpty(manager)) {
						continue;
					}
					rows2 += 1;
				}

			}
			

			System.out.println("rows=" + rows + ",rows2=" + rows2);
			result.setCode(Constant.OK); // 2
			result.setMsg(Constant.ADD_OK); // 添加成功
			if(rows==rows2) {
				result.setData(1); //1表示全部评奖完毕  我需要计算每个评委的平均分放在数据库里
				List<Work> allwork = workdao.findAllWork(1);
				for(int n=0;n<allwork.size();n++) {
					int workid3 = allwork.get(n).getWorkid();
					
					//List<Integer> scorelist = expertScoreDao.findAllWoksScore(workid3); //这个list是假的，因为有些评委可能被删了
					List<ExpertScore> scorelist = expertScoreDao.findExpertIdByWorkid(workid3);
					int endScore=0;
					for(ExpertScore expertscore2 : scorelist) {
						int managerid2 = expertscore2.getManagerid();
						if(StringUtils.isEmpty(expertDao.findExpertById(managerid2))) {
							continue;
						}
						endScore+=expertscore2.getExpertscore();
					}
//					for(Integer score:scorelist) {
//						endScore+=score;
//					}
					System.out.println("endScore="+endScore);
					int scoreAverage=endScore/expertCount+endScore%expertCount;  //存入作品数据库
					workdao.addWorkScore(scoreAverage, workid3);
					System.out.println("插入成功");
				}
			}else {
				result.setData(0); //0表示还未评奖完毕
			}
		}

		return result;
	}

}
