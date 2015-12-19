package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.Expdetail;
import service.IExpdetailService;

import javax.annotation.Resource;

@Action (value="expdetailAction",results={
		@Result(name="list",type="redirectAction",location="expdetailAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class ExpdetailAction {

	
	@Resource(name = "expdetailService")
	private IExpdetailService expdetailService;
	
	
	private Expdetail expdetail;
	
	private String expdetailId;
	
	
	public Expdetail getExpdetail() {
		return expdetail;
	}
	public void setExpdetail(Expdetail expdetail) {
		this.expdetail = expdetail;
	}
	public String getExpdetailId() {
		return expdetailId;
	}
	public void setExpdetailId(String expdetailId) {
		this.expdetailId = expdetailId;
	}
	
	
	
	public String add(){
		expdetailService.addoredit(expdetail);
		return "list";
	}
	public String edit(){
		expdetailService.addoredit(expdetail);
		return "list";
	}
	public String delete(){
		expdetailService.deletebyid(Integer.parseInt(expdetailId));
		return "list";
	}
}