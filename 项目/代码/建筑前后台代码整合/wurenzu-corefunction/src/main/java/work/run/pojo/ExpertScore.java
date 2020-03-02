package work.run.pojo;
//单个作品 一个专家的 评分
public class ExpertScore {
	private Integer id;
	private Integer expertscore;//评分
	private Integer managerid;//专家id
	private Integer workid;//作品id
	
	
	public ExpertScore() {
		super();
	}
	
	

	
	public ExpertScore(Integer id, Integer expertscore, Integer managerid, Integer workid) {
		super();
		this.id = id;
		this.expertscore = expertscore;
		this.managerid = managerid;
		this.workid = workid;
	}




	@Override
	public String toString() {
		return "ExpertScore [id=" + id + ", expertscore=" + expertscore + ", managerid=" + managerid + ", workid="
				+ workid + "]";
	}




	public Integer getExpertscore() {
		return expertscore;
	}




	public void setExpertscore(Integer expertscore) {
		this.expertscore = expertscore;
	}




	public Integer getManagerid() {
		return managerid;
	}




	public void setManagerid(Integer managerid) {
		this.managerid = managerid;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Integer getId() {
		return id;
	}
	
	public Integer getWorkid() {
		return workid;
	}
	public void setWorkid(Integer workid) {
		this.workid = workid;
	}
	

}
