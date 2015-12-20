package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IHouseManageService;
import Model.HouseManage;
import Utilx.ViewStringSet;
import ViewModel.HouseManageViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="houseManageAssign",results={
		@Result(name="add",location="/HouseManageaddoredit.jsp"),
		@Result(name="edit",location="/HouseManageaddoredit.jsp"),
		@Result(name="list",location="/HouseManagelist.jsp")})
@Controller
public class HouseManageAssign extends ActionSupport{
	
	private HouseManageViewModel cvm;
	
	 private String houseManageId;
	 
	 @Resource(name = "houseManageService")
	private IHouseManageService houseManageService;

	private List list;

	public HouseManageViewModel getCvm() {
		return cvm;
	}

	public void setCvm(HouseManageViewModel cvm) {
		this.cvm = cvm;
	}

	public String getHouseManageId() {
		return houseManageId;
	}

	public void setHouseManageId(String houseManageId) {
		this.houseManageId = houseManageId;
	}

	
	
	public String add(){
		HouseManageViewModel houseManageViewModel=new HouseManageViewModel();
		
		HouseManage houseManage = new HouseManage();
		
		ViewClass vc=new ViewClass();
		 vc.action="houseManageAction!add";
		 houseManageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(houseManage);
		
		houseManageViewModel.setInput(viewStringSet.Addset());
		
		cvm = houseManageViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		HouseManageViewModel houseManageViewModel=new HouseManageViewModel();
		
		HouseManage houseManage = houseManageService.edit(Integer.parseInt(houseManageId));
		
		ViewClass vc=new ViewClass();
		 vc.action="houseManageAction!edit";
		 houseManageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(houseManage);
		
		houseManageViewModel.setInput(viewStringSet.updateset());
		
		cvm = houseManageViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 HouseManageViewModel houseManageViewModel=new HouseManageViewModel();
		
		 list = houseManageService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			houseManageViewModel.setList(viewStringSet.listSet(list));
			
			cvm = houseManageViewModel;
			
			
			return "list";
	}
	 
	 
	 
	 
}
