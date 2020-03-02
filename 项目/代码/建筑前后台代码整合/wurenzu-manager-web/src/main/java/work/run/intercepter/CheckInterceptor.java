package work.run.intercepter;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import work.run.ManagerServiceRemote.ManagerServiceRemote;
import work.run.util.Constant;
import work.run.util.Result;

/**
 * 用户拦截器 同时实现单点登录
 * @author Think
 *
 */


@Component
public class CheckInterceptor implements HandlerInterceptor{

	
	@Autowired
	private ManagerServiceRemote remote;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("拦截器执行了");
		//获取请求中的userId和token参数
		String userId = request.getParameter("userId");
		String token = request.getParameter("token");
		if(StringUtils.isEmpty(userId)||StringUtils.isEmpty(token)) {
			//失败
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println("验证失败");
			out.println("{\"code\":9,\"msg\":用户不合法}");  //返回用户非法json数据
			return false;
		}

		Result result = remote.authorization(Integer.parseInt(userId), token);
		//判断返回的检测结果
		if(result.getCode()==Constant.OK){
			System.out.println("验证成功");
			return true;//成功
		}else{
			//失败
			System.out.println("验证失败");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("{\"code\":9,\"msg\":用户不合法}");  //返回用户非法json数据
			return false;
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
