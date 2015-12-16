package action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IRegisterService;
import Model.Userinfo;

import com.opensymphony.xwork2.ActionSupport;

@Action (value="userinfoAction",results={
		@Result(name="add",location="/register.jsp"),
		@Result(name="no",type="redirectAction",location="loginAssign?flag=1"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class UserinfoAction extends ActionSupport {
	
		@Resource(name="registerService")
		private IRegisterService registerService;
		
		public void setRegisterService(IRegisterService registerService) {
			this.registerService = registerService;
		}



		private Userinfo userinfo;

		public Userinfo getUserinfo() {
			return userinfo;
		}

		public void setUserinfo(Userinfo userinfo) {
			this.userinfo = userinfo;
		}
		
		
		
		public String add(){
			registerService.register(userinfo);
			return "suc";
		}
}
