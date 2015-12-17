package action;

import java.beans.IntrospectionException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IRegisterService;
import Model.Userinfo;
import Utilx.ViewStringSet;
import ViewModel.RegisterorEditViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

@Action (value="userinfoAssign",results={
	@Result(name="add",location="/register.jsp"),
	@Result(name="edit",location="/register.jsp"),
	@Result(name="list",location="/userinfolist.jsp")})
@Controller
public class RegisterorEditAssign extends ActionSupport{
	private RegisterorEditViewModel revm;
	private String userid;
	
	@Resource(name="registerService")
	private IRegisterService registerService;
	public RegisterorEditViewModel getRevm() {
		return revm;
	}

	public void setRevm(RegisterorEditViewModel revm) {
		this.revm = revm;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String register() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		
		  RegisterorEditViewModel registerorEditViewModel = new RegisterorEditViewModel(); 
		  Userinfo userinfo = new Userinfo();
		  
		  ViewClass vc=new ViewClass();
		  vc.action="userinfoAction!add";
		  registerorEditViewModel.viewclass=vc;
		  
		  ViewStringSet viewStringSet = new ViewStringSet(userinfo);
		  
		  registerorEditViewModel.setInput(viewStringSet.Addset());
		  this.revm=registerorEditViewModel;
		  return "add";
		  
	}
	public String edit() throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException{
		RegisterorEditViewModel registerorEditViewModel = new RegisterorEditViewModel();

		Userinfo userinfo = registerService.edit(Integer.parseInt(userid));
		  
		  ViewClass vc=new ViewClass();
		  vc.action="userinfoAction!edit";
		  registerorEditViewModel.viewclass=vc;
		  
		  ViewStringSet viewStringSet = new ViewStringSet(userinfo);
		  
		  registerorEditViewModel.setInput(viewStringSet.updateset());
		  this.revm=registerorEditViewModel;
		  return "edit";
		
	}
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		RegisterorEditViewModel registerorEditViewModel = new RegisterorEditViewModel(); 
		  
		  ViewClass vc=new ViewClass();
		  vc.header="sadas";
		  registerorEditViewModel.viewclass=vc;
		  ViewStringSet viewStringSet = new ViewStringSet();
		  
		  
		  List list=registerService.findall();
		  
		  registerorEditViewModel.list =viewStringSet.listSet(list);
		  
		  revm=registerorEditViewModel;
		  
		  return "list";
		  
		  
	}
}
