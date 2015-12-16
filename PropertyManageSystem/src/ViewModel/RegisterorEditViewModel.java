package ViewModel;

public class RegisterorEditViewModel {
	
	
	
	
	
	public ViewClass viewclass;
	public ViewClass getViewclass() {
		return viewclass;
	}
	public void setViewclass(ViewClass viewclass) {
//		viewclass=new ViewClass();
		this.viewclass=viewclass;
	}
	
	
	
	
	
	
	
	public RegisterorEditViewModel(String userid, String username,
			String password, String realname, String sex, String telnumber,
			String email, String address, String tag) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.telnumber = telnumber;
		this.email = email;
		this.address = address;
		this.tag = tag;
	}







	public RegisterorEditViewModel() {
		// TODO Auto-generated constructor stub
	}




	public String list;

	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}


	private String input;

	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}




	//datamodel
	private String userid;
	private String username;
	private String password;
	private String realname;
	private String sex;
	private String telnumber;
	private String email;
	private String address;
	private String tag;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelnumber() {
		return telnumber;
	}
	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
