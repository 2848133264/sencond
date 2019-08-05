package EntityP.person;

public class person {
	
	/**
	 * 病人的实体类
	 * 
	 */

	private int id;
	private String name;
	private String age;
	private String gender;
	private String isMarry;//是否已婚
	private String inDate;//就诊时间
	private String birthday;//出生
	private String company ;//单位，工作的地方
	private String phone;//电话
	private String idCard;//身份
	private String address;//住址
	private String bingshi;
	private String xianzhuang;
	private String result;//诊断结果
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIsMarry() {
		return isMarry;
	}
	public void setIsMarry(String isMarry) {
		this.isMarry = isMarry;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBingshi() {
		return bingshi;
	}
	public void setBingshi(String bingshi) {
		this.bingshi = bingshi;
	}
	public String getXianzhuang() {
		return xianzhuang;
	}
	public void setXianzhuang(String xianzhuang) {
		this.xianzhuang = xianzhuang;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return id + "," + name + "," + age + "," + gender + "," + isMarry
				+ "," + inDate + "," + birthday + "," + company + "," + phone
				+ "," + idCard + "," + address + "," + bingshi + "," + xianzhuang
				+ "," + result;
	}

	//person person =new person(id, name, age, gender, isMarray, inDate, birthday, company, phone, idCard, address);
	public person(int id, String name, String age, String gender, String inDate, String phone, String idCard,
			String address, String bingshi, String xianzhuang, String result) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.inDate = inDate;
		this.phone = phone;
		this.idCard = idCard;
		this.address = address;
		this.bingshi = bingshi;
		this.xianzhuang = xianzhuang;
		this.result = result;
	}
	//person person =new person(id, name, age, gender, isMarray, inDate, birthday, company, phone, idCard, address);
	public person(String name, String age, String gender, String isMarry, String inDate, String birthday,
			String company, String phone, String idCard, String address, String bingshi, String xianzhuang,
			String result) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.isMarry = isMarry;
		this.inDate = inDate;
		this.birthday = birthday;
		this.company = company;
		this.phone = phone;
		this.idCard = idCard;
		this.address = address;
		this.bingshi = bingshi;
		this.xianzhuang = xianzhuang;
		this.result = result;
	}
	//person person =new person(id, name, age, gender, isMarray, inDate, birthday, company, phone, idCard, address);
	public person(int id, String name, String age, String gender, String isMarry, String inDate, String birthday,
			String company, String phone, String idCard, String address, String bingshi, String xianzhuang,
			String result) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.isMarry = isMarry;
		this.inDate = inDate;
		this.birthday = birthday;
		this.company = company;
		this.phone = phone;
		this.idCard = idCard;
		this.address = address;
		this.bingshi = bingshi;
		this.xianzhuang = xianzhuang;
		this.result = result;
	}
	public person() {
		super();
		// TODO Auto-generated constructor stub
	}
					
	//person person =new person(id, name, age, gender, isMarray, inDate, birthday, company, phone, idCard, address);
	public person(int id,String name, String gender, String isMarry, String phone, String idCard, String xianzhuang,
			String result) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.isMarry = isMarry;
		this.phone = phone;
		this.idCard = idCard;
		this.xianzhuang = xianzhuang;
		this.result = result;
	}
	//person person =new person(id, name, age, gender, isMarray, inDate, birthday, company, phone, idCard, address);
	public person(int id, String name, String age, String gender, String inDate, String birthday, String phone,
			String idCard, String address, String bingshi, String xianzhuang, String result) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.inDate = inDate;
		this.birthday = birthday;
		this.phone = phone;
		this.idCard = idCard;
		this.address = address;
		this.bingshi = bingshi;
		this.xianzhuang = xianzhuang;
		this.result = result;
	}
	
	
	
	
}
