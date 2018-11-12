package beans;

/**
 * ユーザデータ
 *
 *
 */
public class UserBeans{
	private int id;
	private String loginId;
	private String userName;
	private String phone;
	private String password;

	// コンストラクタ
	public UserBeans() {
	}

	// ログインセッションを保存するためのコンストラクタ
		public UserBeans(String loginId, String userName) {
			this.loginId = loginId;
			this.userName = userName;
		}

		//
		public UserBeans(int id,String loginId,String userName,String phone) {
			this.id = id;
			this.loginId = loginId;
			this.userName = userName;
			this.phone = phone;
		}

		//
		public UserBeans(int id,String loginId,String userName,String phone,String password) {
			this.id = id;
			this.loginId = loginId;
			this.userName = userName;
			this.phone = phone;
			this.password = password;
		}

	//setter,getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}