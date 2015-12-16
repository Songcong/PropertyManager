package ViewModel;

import Model.Userinfo;

public class LoginViewModel {
	
	public ViewClass viewclass;
	
	public LoginViewModel(){
		ViewClass vc=new ViewClass();
		this.viewclass=vc;
	}
	
	
	public ViewClass getViewclass() {
		return viewclass;
	}
	public void setViewclass(ViewClass viewclass) {
//		viewclass=new ViewClass();
		this.viewclass=viewclass;
	}
	private String input;
	
	public String getInput() {
		return input;
	}


	public void setInput(String input) {
		this.input = input;
	}
	private String userid;
	private String username;
	private String password;
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


	
	
	
	


	
	
	
}
