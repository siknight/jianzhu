package work.run.util;

import java.io.Serializable;
/**
 *用户验证 令牌类  用于SSO单点登录
 * @author si
 *
 */
public class Token implements Serializable{
	/**
	 * 随机生成的令牌id
	 */
	private String tokenId;
	private int userId;
	/**
	 * 创建时间
	 */
	private long createTime;
	/**
	 * 预期存储时间
	 */
	private long expire;  
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getExpire() {
		return expire;
	}
	public void setExpire(long expire) {
		this.expire = expire;
	}
	
	public String toString(){
		return tokenId+"-"+userId+"-"+createTime;
	}
	
}
