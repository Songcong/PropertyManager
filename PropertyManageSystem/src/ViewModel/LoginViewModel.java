package ViewModel;

public class LoginViewModel {
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
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
	
	
	
	
	
	private String header;
	private String footer;
	private String form;
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}





	//datafields
	private String username;
	private String password;
	
}
