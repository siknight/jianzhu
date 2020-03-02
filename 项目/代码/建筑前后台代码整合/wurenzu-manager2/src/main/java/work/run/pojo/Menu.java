package work.run.pojo;

import java.io.Serializable;
import java.util.List;

public class Menu  implements Serializable{
	private Integer menuid;
	private Integer pid;
	private String menuname;
	private String url;
	
	private List<Menu> ziMenu;
	
	
	public Integer getMenuid() {
		return menuid;
	}
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public List<Menu> getZiMenu() {
		return ziMenu;
	}
	public void setZiMenu(List<Menu> ziMenu) {
		this.ziMenu = ziMenu;
	}
	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", pid=" + pid + ", menuname=" + menuname + ", url=" + url + ", ziMenu="
				+ ziMenu + "]";
	}
	
	
	

}
