package work.run.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Firmuser  implements Serializable{
	private int id;
	private String name;
	private String image;
	private Timestamp regtime;
	private String firmName;
	private String firmDetail;
	private String email;
	private String phone;
	private String represent;  //公司法人
	private String address;
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
	@Override
	public String toString() {
		return "firmuser [id=" + id + ", name=" + name + ", image=" + image + ", regtime=" + regtime + ", firmName="
				+ firmName + ", firmDetail=" + firmDetail + ", email=" + email + ", phone=" + phone + ", represent="
				+ represent + ", address=" + address + "]";
	}
	
	
	

}
