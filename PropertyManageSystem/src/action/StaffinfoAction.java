package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.Staffinfo;
import service.IStaffinfoService;

import javax.annotation.Resource;

@Action (value="staffinfoAction",results={
		@Result(name="list",type="redirectAction",location="staffinfoAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class StaffinfoAction {

	
	@Resource(name = "staffinfoService")
	private IStaffinfoService staffinfoService;
	
	
	private Staffinfo staffinfo;
	
	private String staffinfoId;
	
	
	public Staffinfo getStaffinfo() {
		return staffinfo;
	}
	public void setStaffinfo(Staffinfo staffinfo) {
		this.staffinfo = staffinfo;
	}
	public String getStaffinfoId() {
		return staffinfoId;
	}
	public void setStaffinfoId(String staffinfoId) {
		this.staffinfoId = staffinfoId;
	}
	
	
	
	public String add(){
		staffinfoService.addoredit(staffinfo);
		return "list";
	}
	public String edit(){
		staffinfoService.addoredit(staffinfo);
		return "list";
	}
	public String delete(){
		staffinfoService.deletebyid(Integer.parseInt(staffinfoId));
		return "list";
	}
}
