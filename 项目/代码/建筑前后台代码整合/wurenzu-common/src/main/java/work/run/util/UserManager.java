package work.run.util;

import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
/**
 * 
 * SSO单点登录工具类 
 * 方法一：创建令牌，并用redis存储令牌
 * 方法二：
 * @author si
 *
 */
@Component
public class UserManager {
	
	@Autowired
	private RedisTemplate<Object, Object> redis;
	
	
	/**
	 * 根据UserID生成令牌
	 * @param userId
	 * @return 令牌号-用户ID-颁发时间
	 */
	public String createToken(int userId){
		//用uuid生成一个身份令牌
		UUID uuid = UUID.randomUUID();
		String uid = uuid.toString();
		long time = System.currentTimeMillis();  
		//将taken对象化
		Token tk = new Token();
		tk.setUserId(userId);  //用户id
		tk.setTokenId(uid);   //令牌
		tk.setCreateTime(time);
		tk.setExpire(24*3600*1000);//设置一天有效,单位毫秒
		
		//服务器留存一份
		
		//服务器留存，存入redis缓存服务器，用于将来身份认证使用  key为"token_"+userId 
		//tk组成规则   tokenId+"-"+userId+"-"+createTime;  
		redis.opsForValue().set("token_"+userId, tk);
		//对tk.toString()结果用Base64加密，然后再返回
		String base64Token = Base64.getEncoder()
			.encodeToString(tk.toString().getBytes());  
		System.out.println(base64Token);
		return base64Token;   //给用户一份
	}
	
	/**
	 * 检验token有效性
	 * @param userId
	 * @param token
	 * @return true有效;false失效
	 */
	public boolean checkToken(int userId,String base64Token){
		//1. 根据userId获取服务端的token
		Token tk = (Token)redis.opsForValue().get("token_"+userId);
		//2. 检查用户token和服务端token是否一致
		if(tk != null){
			//对redis取出来的加密和http传过来的比对
			String token = Base64.getEncoder()
				.encodeToString(tk.toString().getBytes());
			
			if(token.equals(base64Token)){//token一致
				//3. 检查token是否失效
				long expireTime = tk.getCreateTime()+tk.getExpire();  //当时存储设置的有效期
				long currTime = System.currentTimeMillis();  //当前时间
				//当时存储设置的有效期>当前时间时说明有效
				if(expireTime>currTime){//在有效期内
					return true;
				}
			}
		}
		return false;
	}
	
	
	
}
