package work.run.pojo;

import java.io.Serializable;

public class Race  implements Serializable{
	
	private int id ;
	private String raceName;
	private String details;
	private int period;
	
	
	
	private int status;
	
	private String imgUrl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "Race [id=" + id + ", raceName=" + raceName + ", details=" + details + ", period=" + period + ", status="
				+ status + "]";
	}
	

}
