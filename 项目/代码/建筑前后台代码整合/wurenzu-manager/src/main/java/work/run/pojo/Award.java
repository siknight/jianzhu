package work.run.pojo;

import java.io.Serializable;

public class Award implements Serializable {
	private int aid;
	private String aname;
	private int price;
	private int workid;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getWorkid() {
		return workid;
	}
	public void setWorkid(int workid) {
		this.workid = workid;
	}
	@Override
	public String toString() {
		return "Award [aid=" + aid + ", aname=" + aname + ", price=" + price + ", workid=" + workid + "]";
	}


	
	
	

}
