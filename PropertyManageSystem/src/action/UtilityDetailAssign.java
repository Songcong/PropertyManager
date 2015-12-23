package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IUtilityDetailService;
import Model.UtilityDetail;
import Utilx.ViewStringSet;
import ViewModel.UtilityDetailViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="utilityDetailAssign",results={
		@Result(name="add",location="/UtilityDetailaddoredit.jsp"),
		@Result(name="edit",location="/UtilityDetailaddoredit.jsp"),
		@Result(name="list",location="/UtilityDetaillist.jsp")})
@Controller
public class UtilityDetailAssign extends ActionSupport{
	
	private UtilityDetailViewModel cvm;
	
	 private String utilityId;
	 
	 @Resource(name = "utilityDetailService")
	private IUtilityDetailService utilityDetailService;

	private List list;

	public UtilityDetailViewModel getCvm() {
		return cvm;
	}

	public void setCvm(UtilityDetailViewModel cvm) {
		this.cvm = cvm;
	}

	

	
	
	public String getUtilityId() {
		return utilityId;
	}

	public void setUtilityId(String utilityId) {
		this.utilityId = utilityId;
	}

	public String add(){
		UtilityDetailViewModel utilityDetailViewModel=new UtilityDetailViewModel();
		
		UtilityDetail utilityDetail = new UtilityDetail();
		
		ViewClass vc=new ViewClass();
		 vc.action="utilityDetailAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加设备详细信息</h2></div>";
		 utilityDetailViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(utilityDetail);
		
		utilityDetailViewModel.setInput(viewStringSet.Addset());
		
		cvm = utilityDetailViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		UtilityDetailViewModel utilityDetailViewModel=new UtilityDetailViewModel();
		
		UtilityDetail utilityDetail = utilityDetailService.edit(Integer.parseInt(utilityId));
		
		ViewClass vc=new ViewClass();
		 vc.action="utilityDetailAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑设备详细信息</h2></div>";
		 utilityDetailViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(utilityDetail);
		
		utilityDetailViewModel.setInput(viewStringSet.updateset());
		
		cvm = utilityDetailViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 UtilityDetailViewModel utilityDetailViewModel=new UtilityDetailViewModel();
		
		 list = utilityDetailService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			utilityDetailViewModel.setList(viewStringSet.listSet(list));
			
			cvm = utilityDetailViewModel;
			
			
			return "list";
	}
	 
	 
	 
	 
}
