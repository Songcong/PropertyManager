package action;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.IExpdetailService;
import Model.Expdetail;
import Utilx.ViewStringSet;
import ViewModel.ExpdetailViewModel;
import ViewModel.ViewClass;


@Action (value="expdetailAssign",results={
		@Result(name="add",location="/Expdetailaddoredit.jsp"),
		@Result(name="edit",location="/Expdetailaddoredit.jsp"),
		@Result(name="list",location="/Expdetaillist.jsp")})
@Controller
public class ExpdetailAssign extends ActionSupport {

	private ExpdetailViewModel cvm;
	
	 private String expdetailId;
	 
	 @Resource(name = "expdetailService")
	private IExpdetailService expdetailService;

	private List list;

	public ExpdetailViewModel getCvm() {
		return cvm;
	}

	public void setCvm(ExpdetailViewModel cvm) {
		this.cvm = cvm;
	}

	public String getExpdetailId() {
		return expdetailId;
	}

	public void setExpdetailId(String expdetailId) {
		this.expdetailId = expdetailId;
	}

	
	
	public String add(){
		ExpdetailViewModel expdetailViewModel=new ExpdetailViewModel();
		
		Expdetail expdetail = new Expdetail();
		
		ViewClass vc=new ViewClass();
		 vc.action="expdetailAction!add";
		 expdetailViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(expdetail);
		
		expdetailViewModel.setInput(viewStringSet.Addset());
		
		cvm = expdetailViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		ExpdetailViewModel expdetailViewModel=new ExpdetailViewModel();
		
		Expdetail expdetail = expdetailService.edit(Integer.parseInt(expdetailId));
		
		ViewClass vc=new ViewClass();
		 vc.action="expdetailAction!edit";
		 expdetailViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(expdetail);
		
		expdetailViewModel.setInput(viewStringSet.updateset());
		
		cvm = expdetailViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 ExpdetailViewModel expdetailViewModel=new ExpdetailViewModel();
		
		 list = expdetailService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			expdetailViewModel.setList(viewStringSet.listSet(list));
			
			cvm = expdetailViewModel;
			
			
			return "list";
	}
	public String findbyid() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		ExpdetailViewModel expdetailViewModel=new ExpdetailViewModel();
		List list1=new ArrayList();
		list1.add(expdetailService.edit(Integer.parseInt(expdetailId)));
		
		ViewStringSet viewStringSet = new ViewStringSet();
			
		expdetailViewModel.setList(viewStringSet.listSet(list1));
		
		cvm=expdetailViewModel;
		
		return "list";
		
	}
}
