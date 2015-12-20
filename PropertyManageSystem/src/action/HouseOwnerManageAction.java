package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.HouseOwnerManage;
import service.IHouseOwnerManageService;

import javax.annotation.Resource;

@Action (value="houseOwnerManageAction",results={
		@Result(name="list",type="redirectAction",location="houseOwnerManageAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class HouseOwnerManageAction {

	
	@Resource(name = "houseOwnerManageService")
	private IHouseOwnerManageService houseOwnerManageService;
	
	
	private HouseOwnerManage houseOwnerManage;
	
	private String houseOwnerManageId;
	
	
	public HouseOwnerManage getHouseOwnerManage() {
		return houseOwnerManage;
	}
	public void setHouseOwnerManage(HouseOwnerManage houseOwnerManage) {
		this.houseOwnerManage = houseOwnerManage;
	}
	public String getHouseOwnerManageId() {
		return houseOwnerManageId;
	}
	public void setHouseOwnerManageId(String houseOwnerManageId) {
		this.houseOwnerManageId = houseOwnerManageId;
	}
	
	
	
	public String add(){
		houseOwnerManageService.addoredit(houseOwnerManage);
		return "list";
	}
	public String edit(){
		houseOwnerManageService.addoredit(houseOwnerManage);
		return "list";
	}
	public String delete(){
		houseOwnerManageService.deletebyid(Integer.parseInt(houseOwnerManageId));
		return "list";
	}
}
