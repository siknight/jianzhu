package work.run.pojo;

import java.sql.Timestamp;
/**
 * 参赛者信息
 * @author Liurenzu
 *
 */

public class FirmUser {
	/*
	 * 这个是公共接口 最好不要涉及到个人隐私
	 * 密码之类的不能出现在这里 
	 */
	private int id;
	private String name;
	private String image;
	private Timestamp regtime;
	private String firmName;
	private String firmDetail;
	private String email;
	private String phone;
	private String represent;
	private String address;
	
//	@Override
//	public String toString() {
//		return "FirmUser [id=" + id + ", name=" + name + ", image=" + image + ", regtime=" + regtime + ", firmName="
//				+ firmName + ", firmDetail=" + firmDetail + ", email=" + email + ", phone=" + phone + ", represent="
//				+ represent + ", address=" + address + "]";
//	}

	@Override
	public String toString() {
		
		return this.firmName;
	}
	
	public FirmUser() {
		super();
	}

	public FirmUser(int id, String name, String image, Timestamp regtime, String firmName, String firmDetail,
			String email, String phone, String represent, String address) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.regtime = regtime;
		this.firmName = firmName;
		this.firmDetail = firmDetail;
		this.email = email;
		this.phone = phone;
		this.represent = represent;
		this.address = address;
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
	
}
