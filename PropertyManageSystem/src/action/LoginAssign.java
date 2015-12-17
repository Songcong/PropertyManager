package action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import Model.Login;
import Model.Userinfo;
import Utilx.ViewStringSet;
import ViewModel.LoginViewModel;


@Action(value="/loginAssign",results={@Result(name="ok",location="/login.jsp")})
@Controller
public class LoginAssign extends ActionSupport{
		private List<String> list;
		private Field[] fields;
		private LoginViewModel lvm;
		private  int flag;
			
		
		public int getFlag() {
			return flag;
		}
		public void setFlag(int flag) {
			this.flag = flag;
		}
		public LoginViewModel getLvm() {
			return lvm;
		}
		public void setLvm(LoginViewModel lvm) {
			this.lvm = lvm;
		}
		public List<String> getList() {
			return list;
		}
		public void setList(List<String> list) {
			this.list = list;
		}
		public Field[] getFields() {
			return fields;
		}
		public void setFields(Field[] fields) {
			this.fields = fields;
		}

		public String execute() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
			
			LoginViewModel loginViewModel = new LoginViewModel();
			Userinfo userinfo =new Userinfo();
			

			ViewStringSet viewStringSet = new ViewStringSet(userinfo);
			
			loginViewModel.viewclass.setHeader("<header>");
			loginViewModel.viewclass.setFooter("<footer>");
			loginViewModel.viewclass.setAction("loginAction!login");
			loginViewModel.setUsername("用户名：");
			loginViewModel.setPassword("密码：");
			
			
			List<Object> list=new ArrayList<Object>();
			
			
			loginViewModel.setInput(viewStringSet.Addset());
			
			//loginViewModel=(LoginViewModel) viewStringSet.updateset();
			//loginViewModel=(LoginViewModel) viewStringSet.listSet(list);
			
			lvm=loginViewModel;
			
			//fields = loginViewModel.getClass().getDeclaredFields();
			
			if(flag==1)
			{
				loginViewModel.viewclass.setMessage("<script>alert('密码或用户名错误请重新输入！！');</script>");
			}
			else{
				loginViewModel.viewclass.setMessage("");
			}
			
			return "ok";
		}
		
		
		
		
		
}
