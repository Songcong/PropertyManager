package action;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import Model.Login;
import Utilx.ViewStringSet;
import ViewModel.LoginViewModel;


@Action(value="/loginAssign",results={@Result(name="ok",location="/login.jsp")})
@Controller
public class LoginAssign extends ActionSupport{
		private List<String> list;
		private Field[] fields;
		private LoginViewModel lvm;
			
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

		public String execute() throws IllegalArgumentException, IllegalAccessException{
			
			LoginViewModel loginViewModel = new LoginViewModel();
			Login login = new Login();
			
			login.setPassword("sajkdljal");
			login.setUsername("sadasd");
			ViewStringSet viewStringSet = new ViewStringSet(login, loginViewModel);
			
			loginViewModel.setHeader("<header>");
			loginViewModel.setFooter("<footer>");
			loginViewModel.setUsername("用户名：");
			loginViewModel.setPassword("密码：");
			
			//loginViewModel=(LoginViewModel) viewStringSet.Addset();
			
			loginViewModel=(LoginViewModel) viewStringSet.updateset();
			
			lvm=loginViewModel;
			
			//fields = loginViewModel.getClass().getDeclaredFields();
			
			
			return "ok";
		}
		
		
		
		
		
}
