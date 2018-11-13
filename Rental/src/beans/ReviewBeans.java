package beans;

/**
 * レビューデータ
 *
 *
 */
public class ReviewBeans{
	private int revId;
	private int userId;
	private String userName;
	private int castId;
	private String revC;


	// コンストラクタ
	public ReviewBeans() {
	}

	//
	public ReviewBeans(int revId,int userId,String userName,int castId,String revC) {
		this.revId = revId;
		this.userId = userId;
		this.userName = userName;
		this.castId = castId;
		this.revC = revC;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}