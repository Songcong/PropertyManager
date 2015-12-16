package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import Model.Userinfo;
import Utilx.ViewStringSet;
import ViewModel.RegisterorEditViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

@Action (value="registeroreditassign",results={
	@Result(name="add",location="/register.jsp"),
	@Result(name="no",type="redirectAction",location="loginAssign?flag=1")})
public class RegisterorEditAssign extends ActionSupport{
	private RegisterorEditViewModel revm;
	
	public RegisterorEditViewModel getRevm() {
		return revm;
	}

	public void setRevm(RegisterorEditViewModel revm) {
		this.revm = revm;
	}

	public String register() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		  RegisterorEditViewModel registerorEditViewModel = new RegisterorEditViewModel(
				  "","用户名","密码","真实姓名","性别","电话号码","邮箱","地址",""
				  ); 
		  Userinfo userinfo = new Userinfo();
		  
		  ViewClass vc=new ViewClass();
		  vc.action="userinfoAction!add";
		  registerorEditViewModel.viewclass=vc;
		  
		  ViewStringSet viewStringSet = new ViewStringSet(userinfo,registerorEditViewModel);
		  
		  registerorEditViewModel = (RegisterorEditViewModel) viewStringSet.Addset();
		  this.revm=registerorEditViewModel;
		  return "add";
		  
	}
	public String edit() throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException{
		RegisterorEditViewModel registerorEditViewModel = new RegisterorEditViewModel(
				  "","用户名","密码","真实姓名","性别","电话号码","邮箱","地址",""
				  );
		Userinfo userinfo = new Userinfo();
		  
		  ViewClass vc=new ViewClass();
		  vc.action="userinfoAction!edit";
		  registerorEditViewModel.viewclass=vc;
		  
		  ViewStringSet viewStringSet = new ViewStringSet(userinfo,registerorEditViewModel);
		  
		  registerorEditViewModel = (RegisterorEditViewModel) viewStringSet.updateset();
		  this.revm=registerorEditViewModel;
		  return "add";
		
	}
}
