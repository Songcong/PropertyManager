package action;

import java.beans.IntrospectionException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import service.IFamilyDetailService;
import Model.FamilyDetail;
import Utilx.ViewStringSet;
import ViewModel.FamilyDetailViewModel;
import ViewModel.ViewClass;

import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

@Action (value="familyDetailAssign",results={
		@Result(name="add",location="/FamilyDetailaddoredit.jsp"),
		@Result(name="edit",location="/FamilyDetailaddoredit.jsp"),
		@Result(name="list",location="/FamilyDetaillist.jsp")})
@Controller
public class FamilyDetailAssign extends ActionSupport{
	
	private FamilyDetailViewModel cvm;
	
	 private String familyDetailId;
	 
	 @Resource(name = "familyDetailService")
	private IFamilyDetailService familyDetailService;

	private List list;

	public FamilyDetailViewModel getCvm() {
		return cvm;
	}

	public void setCvm(FamilyDetailViewModel cvm) {
		this.cvm = cvm;
	}

	public String getFamilyDetailId() {
		return familyDetailId;
	}

	public void setFamilyDetailId(String familyDetailId) {
		this.familyDetailId = familyDetailId;
	}

	
	
	public String add(){
		FamilyDetailViewModel familyDetailViewModel=new FamilyDetailViewModel();
		
		FamilyDetail familyDetail = new FamilyDetail();
		
		ViewClass vc=new ViewClass();
		 vc.action="familyDetailAction!add";
		 familyDetailViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(familyDetail);
		
		familyDetailViewModel.setInput(viewStringSet.Addset());
		
		cvm = familyDetailViewModel;
		
		
		return "add";
		
	}
	
	public String edit(){
		
		FamilyDetailViewModel familyDetailViewModel=new FamilyDetailViewModel();
		
		FamilyDetail familyDetail = familyDetailService.edit(Integer.parseInt(familyDetailId));
		
		ViewClass vc=new ViewClass();
		 vc.action="familyDetailAction!edit";
		 familyDetailViewModel.viewClass=vc;
		
		ViewStringSet viewStringSet = new ViewStringSet(familyDetail);
		
		familyDetailViewModel.setInput(viewStringSet.updateset());
		
		cvm = familyDetailViewModel;
		
		
		return "edit";
		
	}
	
	public String list() throws IllegalArgumentException, IllegalAccessException, IntrospectionException{
		
		 FamilyDetailViewModel familyDetailViewModel=new FamilyDetailViewModel();
		
		 list = familyDetailService.findall();
		 
		 ViewStringSet viewStringSet = new ViewStringSet();
			
			familyDetailViewModel.setList(viewStringSet.listSet(list));
			
			cvm = familyDetailViewModel;
			
			
			return "list";
	}
	 
	 
	 
	 
}
