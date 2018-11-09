package beans;

import java.util.Date;


/**
 * レビューデータ
 *
 *
 */
public class ReviewBeans{
	private int revId;
	private int userId;
	private int castId;
	private String revC;
	private Date revDate;


	// コンストラクタ
	public ReviewBeans() {
	}




	public int getRevId() {
		return revId;
	}


	public void setRevId(int revId) {
		this.revId = revId;
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


	public String getRevC() {
		return revC;
	}


	public void setRevC(String revC) {
		this.revC = revC;
	}


	public Date getRevDate() {
		return revDate;
	}


	public void setRevDate(Date revDate) {
		this.revDate = revDate;
	}
}