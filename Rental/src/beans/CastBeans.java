package beans;

/**
 * キャストデータ
 *
 *
 */
public class CastBeans{
	private int id;
	private String loginId;
	private String castName;
	private String gender;
	private int age;
	private String bake;
	private String comment;
	private int price;

	// コンストラクタ
	public CastBeans() {
	}

	//
	public CastBeans(int id,String castName,int age,String gender,String bake,String comment,int price) {
		this.id = id;
		this.castName = castName;
		this.age = age;
		this.gender = gender;
		this.bake = bake;
		this.comment = comment;
		this.price = price;
	}
		//
		public CastBeans(int id,String loginId,String castName,int age,String gender,String bake,String comment,int price) {
			this.id = id;
			this.loginId = loginId;
			this.castName = castName;
			this.age = age;
			this.gender = gender;
			this.bake = bake;
			this.comment = comment;
			this.price = price;
	}

		//
		public CastBeans(String loginId,String castName,int age,String gender,String bake,String comment,int price) {
			this.loginId = loginId;
			this.castName = castName;
			this.age = age;
			this.gender = gender;
			this.bake = bake;
			this.comment = comment;
			this.price = price;
	}

		public CastBeans(String castName,String gender,int age) {
			this.castName = castName;
			this.age = age;
			this.gender = gender;
			}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

}