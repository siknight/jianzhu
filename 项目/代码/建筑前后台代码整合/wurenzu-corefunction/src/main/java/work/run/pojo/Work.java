package work.run.pojo;

public class Work {
	private Integer workid;
	private String workname;
	private String imgUrl;
	private Integer grade;
	private Integer firmUserid;
	private String details;
	private String period;
	private Integer status;
	
	@Override
	public String toString() {
		return "Work [workid=" + workid + ", workname=" + workname + ", imgUrl=" + imgUrl + ", grade=" + grade
				+ ", firmUserid=" + firmUserid + ", details=" + details + ", period=" + period + ", status=" + status
				+ "]";
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Work() {
		super();
	}
	
	
	
	public Work(Integer workid, String workname, String imgUrl, Integer grade, Integer firmUserid, String details,
			String period, Integer status) {
		super();
		this.workid = workid;
		this.workname = workname;
		this.imgUrl = imgUrl;
		this.grade = grade;
		this.firmUserid = firmUserid;
		this.details = details;
		this.period = period;
		this.status = status;
	}
	public Integer getWorkid() {
		return workid;
	}
	public void setWorkid(Integer workid) {
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
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getFirmUserid() {
		return firmUserid;
	}
	public void setFirmUserid(Integer firmUserid) {
		this.firmUserid = firmUserid;
	}
	
}
