package beans;

import java.util.Date;


/**
 * 予約データ
 *
 *
 */
public class ReserveBeans{
	private int resId;
	private int userId;
	private int castId;
	private Date rDate;
	private String place;
	private String resCom;
	private Date resDate;


	// コンストラクタ
	public ReserveBeans() {
	}




	public int getResId() {
		return resId;
	}


	public void setResId(int resId) {
		this.resId = resId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getCastId() {
		return castId;
	}


	public void setCastId(int castId) {
		this.castId = castId;
	}


	public Date getrDate() {
		return rDate;
	}


	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getResCom() {
		return resCom;
	}


	public void setResCom(String resCom) {
		this.resCom = resCom;
	}


	public Date getResDate() {
		return resDate;
	}


	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}
}