package work.run.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
/**
 * 用户表
 * @author Liurenzu
 *
 */

public class Manager  implements Serializable{
	
	private static final long serialVersionUID =Long.parseLong("7500818084178651807");
	
	private int id;
	private String name;
	private String password;
	private String nick_name;
	private String sex;
	private String signature;
	private String image;
	private Timestamp regtime;
	private String salt;
	private int roleid;
	private String phone;
	private String email;
	
	private String details;
	
	private ExpertScore expertScore;
	
	private String token;
	
	/**
	 * 角色id
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Timestamp getRegtime() {
		return regtime;
	}
	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
	
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public ExpertScore getExpertScore() {
		return expertScore;
	}
	public void setExpertScore(ExpertScore expertScore) {
		this.expertScore = expertScore;
	}
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", password=" + password + ", nick_name=" + nick_name + ", sex="
				+ sex + ", signature=" + signature + ", image=" + image + ", regtime=" + regtime + ", salt=" + salt
				+ ", roleid=" + roleid + ", details=" + details + ", expertScore=" + expertScore + "]";
	}
	
	
	
	
	

}
