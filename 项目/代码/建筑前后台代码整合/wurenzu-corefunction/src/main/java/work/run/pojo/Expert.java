package work.run.pojo;

//专家信息
public class Expert {
	private int id;
	private String name;
	private String sex;
	private String signature;
	private String image;//头像
	private String details;//描述
	public Expert() {
		super();
	}
	
   
	public Expert(int id, String name, String sex, String signature, String image, String details) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.signature = signature;
		this.image = image;
		this.details = details;
	}


	public String getSignature() {
		return signature;
	}


	public void setSignature(String signature) {
		this.signature = signature;
	}

    

	@Override
	public String toString() {
		return "Expert [id=" + id + ", name=" + name + ", sex=" + sex + ", signature=" + signature + ", image=" + image
				+ ", details=" + details + "]";
	}


	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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
	
}
