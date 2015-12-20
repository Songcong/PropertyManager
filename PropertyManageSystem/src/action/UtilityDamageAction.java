package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.UtilityDamage;
import service.IUtilityDamageService;

import javax.annotation.Resource;

@Action (value="utilityDamageAction",results={
		@Result(name="list",type="redirectAction",location="utilityDamageAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class UtilityDamageAction {

	
	@Resource(name = "utilityDamageService")
	private IUtilityDamageService utilityDamageService;
	
	
	private UtilityDamage utilityDamage;
	
	private String utilityDamageId;
	
	
	public UtilityDamage getUtilityDamage() {
		return utilityDamage;
	}
	public void setUtilityDamage(UtilityDamage utilityDamage) {
		this.utilityDamage = utilityDamage;
	}
	public String getUtilityDamageId() {
		return utilityDamageId;
	}
	public void setUtilityDamageId(String utilityDamageId) {
		this.utilityDamageId = utilityDamageId;
	}
	
	
	
	public String add(){
		utilityDamageService.addoredit(utilityDamage);
		return "list";
	}
	public String edit(){
		utilityDamageService.addoredit(utilityDamage);
		return "list";
	}
	public String delete(){
		utilityDamageService.deletebyid(Integer.parseInt(utilityDamageId));
		return "list";
	}
}
