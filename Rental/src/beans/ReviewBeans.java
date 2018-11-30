package beans;

/**
 * レビューデータ
 *
 *
 */
public class ReviewBeans{
	private int revId;
	private String userId;
	private String userName;
	private String castId;
	private String revC;


	// コンストラクタ
	public ReviewBeans() {
	}

	//
	public ReviewBeans(int revId,String userId,String userName,String castId,String revC) {
		this.revId = revId;
		this.userId = userId;
		this.userName = userName;
		this.castId = castId;
		this.revC = revC;
	}
	//
	public ReviewBeans(String castId,String userId,int revId,String revC) {
		this.castId = castId;
		this.userId = userId;
		this.revId = revId;
		this.revC = revC;
	}


	public int getRevId() {
		return revId;
	}


	public void setRevId(int revId) {
		this.revId = revId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getCastId() {
		return castId;
	}


	public void setCastId(String castId) {
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