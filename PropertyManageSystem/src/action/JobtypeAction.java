package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.Jobtype;
import service.IJobtypeService;

import javax.annotation.Resource;

@Action (value="jobtypeAction",results={
		@Result(name="list",type="redirectAction",location="jobtypeAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class JobtypeAction {

	
	@Resource(name = "jobtypeService")
	private IJobtypeService jobtypeService;
	
	
	private Jobtype jobtype;
	
	private String jobtypeId;
	
	
	public Jobtype getJobtype() {
		return jobtype;
	}
	public void setJobtype(Jobtype jobtype) {
		this.jobtype = jobtype;
	}
	public String getJobtypeId() {
		return jobtypeId;
	}
	public void setJobtypeId(String jobtypeId) {
		this.jobtypeId = jobtypeId;
	}
	
	
	
	public String add(){
		jobtypeService.addoredit(jobtype);
		return "list";
	}
	public String edit(){
		jobtypeService.addoredit(jobtype);
		return "list";
	}
	public String delete(){
		jobtypeService.deletebyid(Integer.parseInt(jobtypeId));
		return "list";
	}
}
