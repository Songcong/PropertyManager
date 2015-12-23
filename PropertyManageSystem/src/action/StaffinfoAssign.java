package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IStaffinfoService;
import Model.Staffinfo;
import Utilx.ViewStringSet;
import ViewModel.StaffinfoViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="staffinfoAssign",results={
		@Result(name="add",location="/Staffinfoaddoredit.jsp"),
		@Result(name="edit",location="/Staffinfoaddoredit.jsp"),
		@Result(name="list",location="/Staffinfolist.jsp")})
@Controller
public class StaffinfoAssign extends ActionSupport{
	
	private StaffinfoViewModel cvm;
	
	 private String staffId;
	 
	 
	 @Resource(name = "staffinfoService")
	private IStaffinfoService staffinfoService;

	private List list;

	public StaffinfoViewModel getCvm() {
		return cvm;
	}

	public void setCvm(StaffinfoViewModel cvm) {
		this.cvm = cvm;
	}


	
	
	public String add(){
		StaffinfoViewModel staffinfoViewModel=new StaffinfoViewModel();
		
		Staffinfo staffinfo = new Staffinfo();
		
		ViewClass vc=new ViewClass();
		 vc.action="staffinfoAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加职员信息</h2></div>";
		 staffinfoViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(staffinfo);
		
		staffinfoViewModel.setInput(viewStringSet.Addset());
		
		cvm = staffinfoViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		StaffinfoViewModel staffinfoViewModel=new StaffinfoViewModel();
		
		Staffinfo staffinfo = staffinfoService.edit(Integer.parseInt(staffId));
		
		ViewClass vc=new ViewClass();
		 vc.action="staffinfoAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑职员信息</h2></div>";
		 staffinfoViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(staffinfo);
		
		staffinfoViewModel.setInput(viewStringSet.updateset());
		
		cvm = staffinfoViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 StaffinfoViewModel staffinfoViewModel=new StaffinfoViewModel();
		
		 list = staffinfoService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			staffinfoViewModel.setList(viewStringSet.listSet(list));
			
			cvm = staffinfoViewModel;
			
			
			return "list";
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	 
	 
	 
	 
}
