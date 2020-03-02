package work.run.pojo;

public class RaceInfo {
	//发布的比赛信息
	private Integer d;
	private String raceName;
	private String details;
	private Integer period;
	private Integer status;
	
	public RaceInfo() {
		super();
	}
		
	@Override
	public String toString() {
		return "RaceInfo [d=" + d + ", raceName=" + raceName + ", details=" + details + ", period=" + period
				+ ", status=" + status + "]";
	}

	public RaceInfo(Integer d, String raceName, String details, Integer period, Integer status) {
		super();
		this.d = d;
		this.raceName = raceName;
		this.details = details;
		this.period = period;
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getD() {
		return d;
	}
	public void setD(Integer d) {
		this.d = d;
	}
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	

}
