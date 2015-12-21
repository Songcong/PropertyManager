package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.FamilyDetail;
import service.IFamilyDetailService;

import javax.annotation.Resource;

@Action (value="familyDetailAction",results={
		@Result(name="list",type="redirectAction",location="familyDetailAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class FamilyDetailAction {

	
	@Resource(name = "familyDetailService")
	private IFamilyDetailService familyDetailService;
	
	
	private FamilyDetail familyDetail;
	
	private String familyId;
	
	
	public FamilyDetail getFamilyDetail() {
		return familyDetail;
	}
	public void setFamilyDetail(FamilyDetail familyDetail) {
		this.familyDetail = familyDetail;
	}
	
	
	
	public String add(){
		familyDetailService.addoredit(familyDetail);
		return "list";
	}
	public String edit(){
		familyDetailService.addoredit(familyDetail);
		return "list";
	}
	public String delete(){
		familyDetailService.deletebyid(Integer.parseInt(familyId));
		return "list";
	}
	public String getFamilyId() {
		return familyId;
	}
	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}
}
