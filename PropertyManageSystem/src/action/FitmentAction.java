package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.Fitment;
import service.IFitmentService;

import javax.annotation.Resource;

@Action (value="fitmentAction",results={
		@Result(name="list",type="redirectAction",location="fitmentAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class FitmentAction {

	
	@Resource(name = "fitmentService")
	private IFitmentService fitmentService;
	
	
	private Fitment fitment;
	
	private String fitmentId;
	
	
	public Fitment getFitment() {
		return fitment;
	}
	public void setFitment(Fitment fitment) {
		this.fitment = fitment;
	}
	public String getFitmentId() {
		return fitmentId;
	}
	public void setFitmentId(String fitmentId) {
		this.fitmentId = fitmentId;
	}
	
	
	
	public String add(){
		fitmentService.addoredit(fitment);
		return "list";
	}
	public String edit(){
		fitmentService.addoredit(fitment);
		return "list";
	}
	public String delete(){
		fitmentService.deletebyid(Integer.parseInt(fitmentId));
		return "list";
	}
}
