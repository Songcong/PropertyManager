package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.Occupation;
import service.IOccupationService;

import javax.annotation.Resource;

@Action (value="occupationAction",results={
		@Result(name="list",type="redirectAction",location="occupationAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class OccupationAction {

	
	@Resource(name = "occupationService")
	private IOccupationService occupationService;
	
	
	private Occupation occupation;
	
	private String occupationId;
	
	
	public Occupation getOccupation() {
		return occupation;
	}
	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}
	public String getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(String occupationId) {
		this.occupationId = occupationId;
	}
	
	
	
	public String add(){
		occupationService.addoredit(occupation);
		return "list";
	}
	public String edit(){
		occupationService.addoredit(occupation);
		return "list";
	}
	public String delete(){
		occupationService.deletebyid(Integer.parseInt(occupationId));
		return "list";
	}
}
