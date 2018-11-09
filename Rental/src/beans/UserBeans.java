package beans;

import java.util.Date;


/**
 * ユーザデータ
 *
 *
 */
public class UserBeans{
	private int userId;
	private String loginId;
	private String userName;
	private String phone;
	private String password;

	private Date createDate;
	private Date updateDate;

	// コンストラクタ
	public UserBeans() {
	}

	// ログインセッションを保存するためのコンストラクタ
		public UserBeans(String loginId, String userName) {
			this.loginId = loginId;
			this.userName = userName;
		}

		//
		public UserBeans(int userId,String loginId,String userName,String phone) {
			this.userId = userId;
			this.loginId = loginId;
			this.userName = userName;
			this.phone = phone;
		}

	//setter,getter
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}