package action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.jasper.tagplugins.jstl.core.Out;

import Model.Login;
import service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;


@Action (value="loginAction",results={
		@Result(name="ok",location="/loginsu.jsp"),
		@Result(name="no",location="/login.jsp")})
@Controller
public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	
	private String message="";
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Resource(name="loginService")
	private LoginService loginService;
	
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
	
	public String login(){
		message="";
		Login login = new Login();
		login.setPassword(password);
		login.setUsername(username);
		List<Login> list=loginService.Login(login);
	    
		if(list.size()>0)
		{
		return "ok";
		}
		else{
		message="<script>alert('密码或用户名错误请重新输入！！');</script>";
		return "no";
		}
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
