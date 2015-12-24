package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IOfforestService;
import Model.Offorest;
import Utilx.ViewStringSet;
import ViewModel.OfforestViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="offorestAssign",results={
		@Result(name="add",location="/Offorestaddoredit.jsp"),
		@Result(name="edit",location="/Offorestaddoredit.jsp"),
		@Result(name="list",location="/Offorestlist.jsp")})
@Controller
public class OfforestAssign extends ActionSupport{
	
	private OfforestViewModel cvm;
	
	 private String afforestId;
	 
	 @Resource(name = "offorestService")
	private IOfforestService offorestService;

	private List list;

	public OfforestViewModel getCvm() {
		return cvm;
	}

	public void setCvm(OfforestViewModel cvm) {
		this.cvm = cvm;
	}


	
	
	public String add(){
		OfforestViewModel offorestViewModel=new OfforestViewModel();
		
		Offorest offorest = new Offorest();
		
		ViewClass vc=new ViewClass();
		 vc.action="offorestAction!add";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>添加小区绿化信息</h2></div>";
		 offorestViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(offorest);
		
		offorestViewModel.setInput(viewStringSet.Addset());
		
		cvm = offorestViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		OfforestViewModel offorestViewModel=new OfforestViewModel();
		
		Offorest offorest = offorestService.edit(Integer.parseInt(afforestId));
		
		ViewClass vc=new ViewClass();
		 vc.action="offorestAction!edit";
		 vc.message="<div class='col-md-6 col-md-offset-1'><h2>编辑小区绿化信息</h2></div>";
		 offorestViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(offorest);
		
		offorestViewModel.setInput(viewStringSet.updateset());
		
		cvm = offorestViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 OfforestViewModel offorestViewModel=new OfforestViewModel();
		
		 list = offorestService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			offorestViewModel.setList(viewStringSet.listSet(list));
			
			cvm = offorestViewModel;
			
			
			return "list";
	}

	public String getAfforestId() {
		return afforestId;
	}

	public void setAfforestId(String afforestId) {
		this.afforestId = afforestId;
	}
	 
	 
	 
	 
}
