package work.run.service;

public class CoreFunctionService {	
	//这里用于写需要几个不同dao 的核心代码
		//用户提交作品 登录了才能提交感觉不用判断用户是否存在,这里还是把判断写上吧
		//period 代表期数 提交作品 期数必须是最新的
//		public Result submitWork(Integer firmUserid, String workname, String imgUrl, String details) {
//			Result result = new Result();
//			
//			if (userdao.findUserById(firmUserid) == null) {
//				result.setCode(Constant.error02); // 1
//				result.setMsg("请注册登录后提交");
//				return result;
//			}
//			int period = raceInfodao.findMaxPeriod();//感觉把最新期数随发布的信息 存在前端也是可以的，这里先这样子写
//			
//			int flag = workdao.insert(workname, imgUrl, firmUserid, details, period);
//			if(flag!=0) {
//				result.setCode(Constant.OK); 
//				result.setMsg("作品提交成功");
//				//result.setData(user);
//				//这里感觉不需要把作品信息存起来，因为前端缓存只存用户个人信息就行了,实在要存，就使用后台缓存和前端缓存技术
//				//使用后台缓存技术的目的是减少对数据库的操作 前端缓存的目的是减少对后台服务器的访问
//				return result;
//			}else {
//				result.setCode(Constant.error02); // 1
//				result.setMsg("作品提交失败");
//				return result;
//			}
//		}
		
	
		
		
		
		//展示今年参赛 作品信息 及 团队信息
//		public Result showThisYearWinWorks() {
//			Result result = new Result();
//			
//			Map<FirmUser,List<Work>> works = new HashMap<FirmUser,List<Work> >();
//			List<FirmUser> firms = userdao.findAllBywork();
//			for(FirmUser firm :firms) {
//				works.put(firm, workdao.findAllByFirmUserId(firm.getId()));
//			}
//			result.setCode(Constant.OK); // 0
//			result.setMsg("今年所有参赛作品和团队信息查询成功");
//			result.setData(works);
//			return result;
//		}
		

}
