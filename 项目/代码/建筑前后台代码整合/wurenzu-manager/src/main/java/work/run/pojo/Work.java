package work.run.pojo;

import java.io.Serializable;
import java.util.List;

public class Work  implements Serializable{
	private int workid;
	private String workname;
	private String imgUrl;
	private int grade; //最终分
	private int firmUserid;
	private String details;
	private int period;  //存入的期数
	private int status;   //状态   
	private Firmuser firmuser;  //一个作品对应一个公司
	private List<Manager> exports;  //一个作品对应多个公司
	private Award award;
	private int pagesize;

	
	public int getWorkid() {
		return workid;
	}


	public void setWorkid(int workid) {
		this.workid = workid;
	}


	public String getWorkname() {
		return workname;
	}


	public void setWorkname(String workname) {
		this.workname = workname;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public int getFirmUserid() {
		return firmUserid;
	}


	public void setFirmUserid(int firmUserid) {
		this.firmUserid = firmUserid;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public int getPeriod() {
		return period;
	}


	public void setPeriod(int period) {
		this.period = period;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Firmuser getFirmuser() {
		return firmuser;
	}


	public void setFirmuser(Firmuser firmuser) {
		this.firmuser = firmuser;
	}


	public List<Manager> getExports() {
		return exports;
	}


	public void setExports(List<Manager> exports) {
		this.exports = exports;
	}


	

	public int getPagesize() {
		return pagesize;
	}


	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


	
	public Award getAward() {
		return award;
	}


	public void setAward(Award award) {
		this.award = award;
	}


	@Override
	public String toString() {
		return "Work [workid=" + workid + ", workname=" + workname + ", imgUrl=" + imgUrl + ", grade=" + grade
				+ ", firmUserid=" + firmUserid + ", details=" + details + ", period=" + period + ", status=" + status
				+ ", firmuser=" + firmuser + ", exports=" + exports + "]";
	}
	
	
	
	

}
