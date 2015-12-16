package action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IRegisterService;
import Model.Userinfo;

import com.opensymphony.xwork2.ActionSupport;

@Action (value="userinfoAction",results={
		@Result(name="list",type="redirectAction",location="userinfoAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class UserinfoAction extends ActionSupport {
	
		@Resource(name="registerService")
		private IRegisterService registerService;
		
		public void setRegisterService(IRegisterService registerService) {
			this.registerService = registerService;
		}
		private String userid;


		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
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
			return "list";
		}
		public String edit(){
			registerService.register(userinfo);
			return "list";
		}
		public String delete(){
			registerService.deletebyid(Integer.parseInt(userid));
			return "list";
		}
}
