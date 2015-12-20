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
	
	 private String utilityDetailId;
	 
	 @Resource(name = "utilityDetailService")
	private IUtilityDetailService utilityDetailService;

	private List list;

	public UtilityDetailViewModel getCvm() {
		return cvm;
	}

	public void setCvm(UtilityDetailViewModel cvm) {
		this.cvm = cvm;
	}

	public String getUtilityDetailId() {
		return utilityDetailId;
	}

	public void setUtilityDetailId(String utilityDetailId) {
		this.utilityDetailId = utilityDetailId;
	}

	
	
	public String add(){
		UtilityDetailViewModel utilityDetailViewModel=new UtilityDetailViewModel();
		
		UtilityDetail utilityDetail = new UtilityDetail();
		
		ViewClass vc=new ViewClass();
		 vc.action="utilityDetailAction!add";
		 utilityDetailViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(utilityDetail);
		
		utilityDetailViewModel.setInput(viewStringSet.Addset());
		
		cvm = utilityDetailViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		UtilityDetailViewModel utilityDetailViewModel=new UtilityDetailViewModel();
		
		UtilityDetail utilityDetail = utilityDetailService.edit(Integer.parseInt(utilityDetailId));
		
		ViewClass vc=new ViewClass();
		 vc.action="utilityDetailAction!edit";
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
