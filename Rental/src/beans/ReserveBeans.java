package beans;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 予約データ
 *
 *
 */
public class ReserveBeans{
	private int id;
	private String userId;
	private String userName;
	private int castId;
	private String loginId;
	private String castName;
	private Date rDate;
	private String place;
	private String resCom;


	// コンストラクタ
	public ReserveBeans() {
	}

	public ReserveBeans(int id,String loginId,String castName) {
		this.id = id;
		this.loginId = loginId;
		this.castName = castName;
}

	public ReserveBeans(String userId,String userName,String loginId,String castName,Date rDate,String place,String resCom) {
		this.userId = userId;
		this.userName = userName;
		this.loginId = loginId;
		this.castName = castName;
		this.rDate = rDate;
		this.place = place;
		this.resCom = resCom;
}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public Date getrDate() {
		return rDate;
	}


	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(rDate);
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




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getCastName() {
		return castName;
	}




	public void setCastName(String castName) {
		this.castName = castName;
	}

	public int getCastId() {
		return castId;
	}

	public void setCastId(int castId) {
		this.castId = castId;
	}


}