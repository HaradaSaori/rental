package beans;

import java.util.Date;


/**
 * キャストデータ
 *
 *
 */
public class CastBeans{
	private int castId;
	private String castName;
	private String gender;
	private int age;
	private String bake;
	private String comment;
	private int price;

	private Date createDate;
	private Date updateDate;

	// コンストラクタ
	public CastBeans() {
	}



	public int getCastId() {
		return castId;
	}

	public void setCastId(int castId) {
		this.castId = castId;
	}

	public String getCastName() {
		return castName;
	}

	public void setCastName(String castName) {
		this.castName = castName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBake() {
		return bake;
	}

	public void setBake(String bake) {
		this.bake = bake;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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