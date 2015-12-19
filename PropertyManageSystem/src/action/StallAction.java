package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.Stall;
import service.IStallService;

import javax.annotation.Resource;

@Action (value="stallAction",results={
		@Result(name="list",type="redirectAction",location="stallAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class StallAction {

	
	@Resource(name = "stallService")
	private IStallService stallService;
	
	
	private Stall stall;
	
	private String stallId;
	
	
	public Stall getStall() {
		return stall;
	}
	public void setStall(Stall stall) {
		this.stall = stall;
	}
	public String getStallId() {
		return stallId;
	}
	public void setStallId(String stallId) {
		this.stallId = stallId;
	}
	
	
	
	public String add(){
		stallService.addoredit(stall);
		return "list";
	}
	public String edit(){
		stallService.addoredit(stall);
		return "list";
	}
	public String delete(){
		stallService.deletebyid(Integer.parseInt(stallId));
		return "list";
	}
}
