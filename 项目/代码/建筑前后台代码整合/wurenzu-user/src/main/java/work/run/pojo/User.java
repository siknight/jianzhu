package work.run.pojo;

import java.sql.Timestamp;

import lombok.Data;
/**
 * 用户表
 * @author Liurenzu
 *
 */
//@Data 不知道为啥没有作用，这里注释掉了
public class User {
	
	private int id;
	private String name;
	private String password;
	private String image;
	private Timestamp regtime;
	private String salt;
	private String firmName;
	private String firmDetail;
	private String email;
	private String phone;
	private String represent;
	private String address;
	
	public User() {
		super();
	}

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

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getFirmDetail() {
		return firmDetail;
	}

	public void setFirmDetail(String firmDetail) {
		this.firmDetail = firmDetail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRepresent() {
		return represent;
	}

	public void setRepresent(String represent) {
		this.represent = represent;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public User(int id, String name, String password, String image, Timestamp regtime, String salt, String firmName,
			String firmDetail, String email, String phone, String represent, String address) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.image = image;
		this.regtime = regtime;
		this.salt = salt;
		this.firmName = firmName;
		this.firmDetail = firmDetail;
		this.email = email;
		this.phone = phone;
		this.represent = represent;
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", image=" + image + ", regtime="
				+ regtime + ", salt=" + salt + ", firmName=" + firmName + ", firmDetail=" + firmDetail + ", email="
				+ email + ", phone=" + phone + ", represent=" + represent + ", address=" + address + "]";
	}
	
	
	
	
	
	

}
