package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.UtilityDetail;
import service.IUtilityDetailService;

import javax.annotation.Resource;

@Action (value="utilityDetailAction",results={
		@Result(name="list",type="redirectAction",location="utilityDetailAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class UtilityDetailAction {

	
	@Resource(name = "utilityDetailService")
	private IUtilityDetailService utilityDetailService;
	
	
	private UtilityDetail utilityDetail;
	
	private String utilityDetailId;
	
	
	public UtilityDetail getUtilityDetail() {
		return utilityDetail;
	}
	public void setUtilityDetail(UtilityDetail utilityDetail) {
		this.utilityDetail = utilityDetail;
	}
	public String getUtilityDetailId() {
		return utilityDetailId;
	}
	public void setUtilityDetailId(String utilityDetailId) {
		this.utilityDetailId = utilityDetailId;
	}
	
	
	
	public String add(){
		utilityDetailService.addoredit(utilityDetail);
		return "list";
	}
	public String edit(){
		utilityDetailService.addoredit(utilityDetail);
		return "list";
	}
	public String delete(){
		utilityDetailService.deletebyid(Integer.parseInt(utilityDetailId));
		return "list";
	}
}
