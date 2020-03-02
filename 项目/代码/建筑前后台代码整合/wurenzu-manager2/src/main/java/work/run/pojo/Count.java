package work.run.pojo;

import java.io.Serializable;

public class Count  implements Serializable{
	private int firmusercount;
	private int firmworkcount;
	public int getFirmusercount() {
		return firmusercount;
	}
	public void setFirmusercount(int firmusercount) {
		this.firmusercount = firmusercount;
	}
	public int getFirmworkcount() {
		return firmworkcount;
	}
	public void setFirmworkcount(int firmworkcount) {
		this.firmworkcount = firmworkcount;
	}
	@Override
	public String toString() {
		return "Count [firmusercount=" + firmusercount + ", firmworkcount=" + firmworkcount + "]";
	}
}
