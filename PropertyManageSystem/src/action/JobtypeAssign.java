package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IJobtypeService;
import Model.Jobtype;
import Utilx.ViewStringSet;
import ViewModel.JobtypeViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="jobtypeAssign",results={
		@Result(name="add",location="/Jobtypeaddoredit.jsp"),
		@Result(name="edit",location="/Jobtypeaddoredit.jsp"),
		@Result(name="list",location="/Jobtypelist.jsp")})
@Controller
public class JobtypeAssign extends ActionSupport{
	
	private JobtypeViewModel cvm;
	
	 private String jobtypeId;
	 
	 @Resource(name = "jobtypeService")
	private IJobtypeService jobtypeService;

	private List list;

	public JobtypeViewModel getCvm() {
		return cvm;
	}

	public void setCvm(JobtypeViewModel cvm) {
		this.cvm = cvm;
	}

	public String getJobtypeId() {
		return jobtypeId;
	}

	public void setJobtypeId(String jobtypeId) {
		this.jobtypeId = jobtypeId;
	}

	
	
	public String add(){
		JobtypeViewModel jobtypeViewModel=new JobtypeViewModel();
		
		Jobtype jobtype = new Jobtype();
		
		ViewClass vc=new ViewClass();
		 vc.action="jobtypeAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加岗位类型信息</h2></div>";
		 jobtypeViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(jobtype);
		
		jobtypeViewModel.setInput(viewStringSet.Addset());
		
		cvm = jobtypeViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		JobtypeViewModel jobtypeViewModel=new JobtypeViewModel();
		
		Jobtype jobtype = jobtypeService.edit(Integer.parseInt(jobtypeId));
		
		ViewClass vc=new ViewClass();
		 vc.action="jobtypeAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑岗位类型信息</h2></div>";
		 jobtypeViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(jobtype);
		
		jobtypeViewModel.setInput(viewStringSet.updateset());
		
		cvm = jobtypeViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 JobtypeViewModel jobtypeViewModel=new JobtypeViewModel();
		
		 list = jobtypeService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			jobtypeViewModel.setList(viewStringSet.listSet(list));
			
			cvm = jobtypeViewModel;
			
			
			return "list";
	}
	 
	 
	 
	 
}
