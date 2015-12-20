package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IHouseOwnerManageService;
import Model.HouseOwnerManage;
import Utilx.ViewStringSet;
import ViewModel.HouseOwnerManageViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="houseOwnerManageAssign",results={
		@Result(name="add",location="/HouseOwnerManageaddoredit.jsp"),
		@Result(name="edit",location="/HouseOwnerManageaddoredit.jsp"),
		@Result(name="list",location="/HouseOwnerManagelist.jsp")})
@Controller
public class HouseOwnerManageAssign extends ActionSupport{
	
	private HouseOwnerManageViewModel cvm;
	
	 private String houseOwnerManageId;
	 
	 @Resource(name = "houseOwnerManageService")
	private IHouseOwnerManageService houseOwnerManageService;

	private List list;

	public HouseOwnerManageViewModel getCvm() {
		return cvm;
	}

	public void setCvm(HouseOwnerManageViewModel cvm) {
		this.cvm = cvm;
	}

	public String getHouseOwnerManageId() {
		return houseOwnerManageId;
	}

	public void setHouseOwnerManageId(String houseOwnerManageId) {
		this.houseOwnerManageId = houseOwnerManageId;
	}

	
	
	public String add(){
		HouseOwnerManageViewModel houseOwnerManageViewModel=new HouseOwnerManageViewModel();
		
		HouseOwnerManage houseOwnerManage = new HouseOwnerManage();
		
		ViewClass vc=new ViewClass();
		 vc.action="houseOwnerManageAction!add";
		 houseOwnerManageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(houseOwnerManage);
		
		houseOwnerManageViewModel.setInput(viewStringSet.Addset());
		
		cvm = houseOwnerManageViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		HouseOwnerManageViewModel houseOwnerManageViewModel=new HouseOwnerManageViewModel();
		
		HouseOwnerManage houseOwnerManage = houseOwnerManageService.edit(Integer.parseInt(houseOwnerManageId));
		
		ViewClass vc=new ViewClass();
		 vc.action="houseOwnerManageAction!edit";
		 houseOwnerManageViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(houseOwnerManage);
		
		houseOwnerManageViewModel.setInput(viewStringSet.updateset());
		
		cvm = houseOwnerManageViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 HouseOwnerManageViewModel houseOwnerManageViewModel=new HouseOwnerManageViewModel();
		
		 list = houseOwnerManageService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			houseOwnerManageViewModel.setList(viewStringSet.listSet(list));
			
			cvm = houseOwnerManageViewModel;
			
			
			return "list";
	}
	 
	 
	 
	 
}
