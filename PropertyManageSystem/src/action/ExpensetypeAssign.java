package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IExpensetypeService;
import Model.Expensetype;
import Utilx.ViewStringSet;
import ViewModel.ExpensetypeViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="expensetypeAssign",results={
		@Result(name="add",location="/Expensetypeaddoredit.jsp"),
		@Result(name="edit",location="/Expensetypeaddoredit.jsp"),
		@Result(name="list",location="/Expensetypelist.jsp")})
@Controller
public class ExpensetypeAssign extends ActionSupport{
	
	private ExpensetypeViewModel cvm;
	
	 private String expensetypeId;
	 
	 @Resource(name = "expensetypeService")
	private IExpensetypeService expensetypeService;

	private List list;

	public ExpensetypeViewModel getCvm() {
		return cvm;
	}

	public void setCvm(ExpensetypeViewModel cvm) {
		this.cvm = cvm;
	}

	public String getExpensetypeId() {
		return expensetypeId;
	}

	public void setExpensetypeId(String expensetypeId) {
		this.expensetypeId = expensetypeId;
	}

	
	
	public String add(){
		ExpensetypeViewModel expensetypeViewModel=new ExpensetypeViewModel();
		
		Expensetype expensetype = new Expensetype();
		
		ViewClass vc=new ViewClass();
		 vc.action="expensetypeAction!add";
		 expensetypeViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(expensetype);
		
		expensetypeViewModel.setInput(viewStringSet.Addset());
		
		cvm = expensetypeViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		ExpensetypeViewModel expensetypeViewModel=new ExpensetypeViewModel();
		
		Expensetype expensetype = expensetypeService.edit(Integer.parseInt(expensetypeId));
		
		ViewClass vc=new ViewClass();
		 vc.action="expensetypeAction!edit";
		 expensetypeViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(expensetype);
		
		expensetypeViewModel.setInput(viewStringSet.updateset());
		
		cvm = expensetypeViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 ExpensetypeViewModel expensetypeViewModel=new ExpensetypeViewModel();
		
		 list = expensetypeService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			expensetypeViewModel.setList(viewStringSet.listSet(list));
			
			cvm = expensetypeViewModel;
			
			
			return "list";
	}
	 
	 
	 
	 
}