package work.run.pojo;

import java.io.Serializable;

public class ExpertScore   implements Serializable{
	private int id;
	private int expertscore;
	private int managerid;
	private int workid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExpertscore() {
		return expertscore;
	}
	public void setExpertscore(int expertscore) {
		this.expertscore = expertscore;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public int getWorkid() {
		return workid;
	}
	public void setWorkid(int workid) {
		this.workid = workid;
	}
	@Override
	public String toString() {
		return "ExpertScore [id=" + id + ", expertscore=" + expertscore + ", managerid=" + managerid + ", workid="
				+ workid + "]";
	}
	
	

}
